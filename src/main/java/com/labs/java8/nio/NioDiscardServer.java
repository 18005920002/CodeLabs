package com.labs.java8.nio;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/5/13
 */
@Slf4j
public class NioDiscardServer {

    public static void main(String[] args) throws IOException {
        startServer();
    }

    public static void startServer() throws IOException {
        // 1.获取选择器
        Selector selector = Selector.open();
        // 2.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 3.设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 4.绑定连接
        serverSocketChannel.bind(new InetSocketAddress(NioDemoConfig.SOCKET_SERVER_PORT));
        log.info("服务器启动成功");
        // 5.将通道注册的“接收新连接”IO事件，注册到选择器上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6.轮询感兴趣的IO就绪事件（选择键集合）
        while (selector.select() > 0) {
            // 7.获取选择键集合
            Iterator<SelectionKey> selectedKeys = selector.selectedKeys().
                    iterator();
            while (selectedKeys.hasNext()) {
                // 8.获取单个的选择键，并处理
                SelectionKey selectedKey = selectedKeys.next();
                // 9.判断key是具体的什么事件
                if (selectedKey.isAcceptable()) {
                    // 10.若选择键的IO事件是“连接就绪”事件,就获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 11.切换为非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 12.将该新连接的通道的可读事件，注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectedKey.isReadable()) {
                    // 13.若选择键的IO事件是“可读”事件, 读取数据
                    SocketChannel socketChannel = (SocketChannel) selectedKey.
                            channel();
                    // 14.读取数据，然后丢弃
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    while ((length = socketChannel.read(byteBuffer)) > 0) {
                        byteBuffer.flip();
                        log.info(new String(byteBuffer.array(), 0, length));
                        byteBuffer.clear();
                    }
                    socketChannel.close();
                }
                // 15.移除选择键
                selectedKeys.remove();
            }
        }
        // 16.关闭连接
        serverSocketChannel.close();
    }
}
