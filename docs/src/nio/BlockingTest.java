package com.labs.jdk5.nio;

import org.testng.annotations.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * NIO完成网络通讯的三个核心： 1. 通道：负责连接 java.nio.channels.Channel |--SelectableChannel
 * |--SocketChannel |--ServerSocketChannel
 * <p>
 * FileChannel不能切换为非阻塞模式，阻塞与非阻塞是针对网络而言
 * <p>
 * <p>
 * 2. 缓冲区：
 * <p>
 * 3. 选择器：监控IO状况
 *
 * @author win10
 */
public class BlockingTest {
    @Test
    public void client() throws Exception {
        // 获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

        // 分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 读取本地文件，发送到服务器
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            sChannel.write(buffer);
            buffer.clear();
        }
        // 关闭通道
        inChannel.close();
        sChannel.close();
    }

    @Test
    public void server() throws Exception {
        // 获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("5.jpg"), StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
        // 绑定连接
        ssChannel.bind(new InetSocketAddress("127.0.0.1", 9898));

        // 获取客户端通道连接
        SocketChannel sChannel = ssChannel.accept();

        // allocate
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (sChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        // close channel
        ssChannel.close();
        outChannel.close();
    }

    @Test
    public void client2() throws Exception {
        // 获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

        // 分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 读取本地文件，发送到服务器
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            sChannel.write(buffer);
            buffer.clear();
        }
        sChannel.shutdownOutput();

        // 接受服务端的反馈
        int len = 0;
        while ((len = sChannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }
        // 关闭通道
        inChannel.close();
        sChannel.close();
    }

    @Test
    public void server2() throws Exception {
        // 获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("5.jpg"), StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
        // 绑定连接
        ssChannel.bind(new InetSocketAddress(9898));

        // 获取客户端通道连接
        SocketChannel sChannel = ssChannel.accept();

        // allocate
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (sChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        //发送反馈给客户端
        buffer.put("服务端接收数据成功".getBytes());
        buffer.flip();
        sChannel.write(buffer);

        // close channel
        ssChannel.close();
        outChannel.close();
        sChannel.close();
    }
}
