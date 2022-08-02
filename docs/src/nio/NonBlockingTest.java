package com.labs.jdk5.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

public class NonBlockingTest {
    @Test
    public void client() throws Exception {
        //获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //切换为非阻塞模式
        sChannel.configureBlocking(false);
        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //发送数据
        buffer.put(new Date().toString().getBytes());
        buffer.flip();
        sChannel.write(buffer);
        buffer.clear();

        //关闭
        sChannel.close();


    }

    @Test
    public void server() throws Exception {

        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        ssChannel.configureBlocking(false);

        ssChannel.bind(new InetSocketAddress(9898));

        //获取选择器
        Selector selector = Selector.open();
        //将通道注册到选择器，指定“监听事件”
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);//选择键：监控通道的什么状态
        //轮询式地获取选择器上已经“准备就绪”的事件
        while (selector.select() > 0) {
            //获取所有注册的选择键
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                //获取准备就绪的事件
                SelectionKey sk = it.next();
                if (sk.isAcceptable()) {
                    SocketChannel sChannel = ssChannel.accept();
                    //切换为非阻塞模式
                    sChannel.configureBlocking(false);
                    //将通道注册到选择器上
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sChannel.read(buffer)) != -1) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                }

                //取消选择键
                it.remove();
            }
        }
    }

    @Test
    public void send() {
		/*DatagramChannel dc = DatagramChannel.open();
		dc.configureBlocking(false);
		ByteBuffer buffer = ByteBuffer.allocate(1024);*/

    }

    @Test
    public void receive() {

    }
}
