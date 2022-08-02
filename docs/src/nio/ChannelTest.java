package com.labs.jdk5.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 1通道用于源节点与目标节点的连接，在NIO中主要负责缓冲区中数据的传输。Channel本身不存储数据，需要配合缓冲区完成工作。
 * <p>
 * 2主要实现类 java.nio.channels.Channel 接口 |--FileChannel |--SocketChannel TCP
 * |--ServerSocketChannel TCP |--DatagramChannel UDP
 * <p>
 * 3获取通道的三种方式： (1) getChannel() 本地IO FileInputStream/FileOutputStream
 * RandomAccessFile
 * <p>
 * 网络IO Socket ServerSocket DatagramSocket
 * <p>
 * (2)NIO.2 针对各个通道提供了open()静态方法
 * (3)NIO.2 通过Files工具类获取通道
 * <p>
 * 4分散于聚集
 * 分散读取：(Scattering Reads)将通道中的数据分散到多个缓冲区
 * 聚集写入：(Gathering Writes)将多个缓冲区的数据聚集到通道中
 *
 * @author win10
 */
public class ChannelTest {

    public static void main(String[] args) throws Exception {

    }

    //分散与聚集
    @Test
    public void test4() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("1.txt", "rw");
        //1.获取通道
        FileChannel fileChannel = raf.getChannel();
        //2.分配缓冲区
        ByteBuffer b1 = ByteBuffer.allocate(100);
        ByteBuffer b2 = ByteBuffer.allocate(1024);
        //ByteBuffer b3 = ByteBuffer.allocate(1024);
        ByteBuffer[] bfs = {b1, b2};

        fileChannel.read(bfs);
        for (ByteBuffer buffer : bfs) {
            buffer.flip();
        }
        System.out.println(new String(bfs[0].array(), 0, bfs[0].limit()));
        System.out.println("-----------------");
        System.out.println(new String(bfs[1].array(), 0, bfs[1].limit()));

        RandomAccessFile f2 = new RandomAccessFile("2.txt", "rw");
        FileChannel channel2 = f2.getChannel();
        channel2.write(bfs);

    }


    @Test
    /**
     * 使用非直接缓冲区完成文件复制
     * @throws Exception
     */
    public void testFileChannel() throws Exception {
        // 利用通道完成文件复制
        FileInputStream fis = new FileInputStream("1.jpg");
        FileOutputStream fos = new FileOutputStream("2.jpg");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer bb = ByteBuffer.allocate(1024);

        // read
        while (inChannel.read(bb) != -1) {
            bb.flip();// 切换为读取模式
            outChannel.write(bb);
            bb.clear();
        }
        outChannel.close();
        inChannel.close();

        fos.close();
        fis.close();
    }

    /**
     * 使用直接缓冲区完成文件复制（内存映射文件），只支持ByteBuffer
     *
     * @throws Exception
     */
    @Test
    public void testFileChannelDirect() throws Exception {
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

        MappedByteBuffer inMappedBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());

        byte[] dst = new byte[inMappedBuffer.limit()];
        inMappedBuffer.get(dst);
        outMappedBuffer.put(dst);
    }


    /**
     * transferFrom
     * transferTo
     *
     * @throws Exception
     */
    @Test
    public void testChannelTransfer() throws Exception {
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("4.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);
        //inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());
        inChannel.close();
        outChannel.close();
    }
}
