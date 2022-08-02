package com.labs.jdk5.nio;

import java.nio.ByteBuffer;

/**
 * Buffer是抽象类，在NIO中负责数据的存取
 * 缓冲区底层就是数组，用于存储不同类型的数据
 * 根据数据类型不同有不同的缓冲区，BOOLEAN除外。
 * <p>
 * 分配allocate()
 * <p>
 * 缓冲区存取数据的两个核心方法
 * put()
 * get()
 * <p>
 * 缓冲区的核心属性
 * private int mark = -1;	//记录当前position,可以通过reset()恢复到mark的位置
 * private int position = 0;//缓冲区中正在操作的数据的位置
 * private int limit;		//缓冲区中可以操作的数据的大小,limit后面的数据不能访问。
 * private int capacity;	//缓冲区最大存储数据的容量，一旦声明不可改变
 * position<=limit<=capacity
 * <p>
 * 直接缓冲区与非直接缓冲区
 *
 * @author win10
 */
public class BufferTest {

    public static void main(String[] args) {
        //分配缓冲区
        ByteBuffer bb = ByteBuffer.allocate(1024);
        System.out.println("----allocate--------");
        System.out.println(bb.position());
        System.out.println(bb.limit());
        System.out.println(bb.capacity());
        String str = "hello";
        bb.put(str.getBytes());//写数据模式
        System.out.println("----put()--------");
        System.out.println(bb.position());
        System.out.println(bb.limit());
        System.out.println(bb.capacity());
        bb.flip();//切换到读数据模式
        System.out.println("----filp()---------");
        System.out.println(bb.position());
        System.out.println(bb.limit());
        System.out.println(bb.capacity());
        byte[] dest = new byte[bb.limit()];
        bb.get(dest);//读取缓冲区的数据
        System.out.println("----get()---------");
        System.out.println(bb.position());
        System.out.println(bb.limit());
        System.out.println(bb.capacity());
        bb.rewind();//重复读数据
        System.out.println("----rewind()---------");
        System.out.println(bb.position());
        System.out.println(bb.limit());
        System.out.println(bb.capacity());
        bb.clear();    //清空缓冲区，但是缓冲区中的数据依然存在
        System.out.println("----clear()---------");
        System.out.println(bb.position());
        System.out.println(bb.limit());
        System.out.println(bb.capacity());
    }
}
