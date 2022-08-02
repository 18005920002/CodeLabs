package com.labs.java8.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/4/21
 */
public class FileChannelTest {
    public static void main(String[] args) throws Exception {
        FileChannelTest.copyWithChannel();
    }

    public static void copyWithChannel() throws Exception {
        FileInputStream fis = new FileInputStream("e:/s1.json");
        FileOutputStream fos = new FileOutputStream("e:/s2.json");
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (inChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        inChannel.close();
        outChannel.close();
    }
}
