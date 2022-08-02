package com.labs.jdk5.juc.traditional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadLocalTest {

    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
    private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();

                    System.out.println(Thread.currentThread().getName() + ": has put data " + data);
                    x.set(data);
                    MyThreadScopeData.getInstance().setName("name " + data);
                    ;
                    MyThreadScopeData.getInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            MyThreadScopeData mydata = MyThreadScopeData.getInstance();
            System.out.println("A from " + Thread.currentThread().getName() + ": get data " + mydata.getName() + "," + mydata.getAge());
        }
    }

    static class B {
        public void get() {
            MyThreadScopeData mydata = MyThreadScopeData.getInstance();
            System.out.println("B from " + Thread.currentThread().getName() + ": get data " + mydata.getName() + "," + mydata.getAge());
        }
    }

}

class MyThreadScopeData {

    private String name;
    private int age;

    private MyThreadScopeData() {
    }

    public static /*synchronized*/ MyThreadScopeData getInstance() {
        MyThreadScopeData instance = map.get(); //拿到的是当前线程的私有数据
        if (null == instance) {
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }

    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
