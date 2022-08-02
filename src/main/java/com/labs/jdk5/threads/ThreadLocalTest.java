package com.labs.jdk5.threads;

import java.util.Random;

public class ThreadLocalTest {

    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
    private static ThreadLocal<MyThreadScopeData> mtsd = new ThreadLocal<MyThreadScopeData>();


    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data:" + data);
                    x.set(data);
				/*	MyThreadScopeData m = new MyThreadScopeData();
					m.setName("name:"+data);
					m.setAge(data);
					mtsd.set(m);*/
                    MyThreadScopeData.getThreadInstance().setName("name:" + data);
                    MyThreadScopeData.getThreadInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
            //Thread.sleep(10);
        }
    }

    static class A {
        public /*int*/void get() {
            int data = x.get();

            System.out.println("A from " + Thread.currentThread().getName() + " get data " + data);

            MyThreadScopeData m = MyThreadScopeData.getThreadInstance();

            System.out.println("A from " + Thread.currentThread().getName() + " get MyThreadScopeData: " + m.getName() + ":" + m.getAge());

            /*return data;*/
        }
    }

    static class B {

        public/* int*/ void get() {
            int data = x.get();
            System.out.println("B from " + Thread.currentThread().getName() + " get data " + data);
            //return data;
        }
    }
}

class MyThreadScopeData {

    private MyThreadScopeData() {
    }
	
/*	public static MyThreadScopeData getInstance(){
		return instance;
	}
	
	private static MyThreadScopeData instance = new MyThreadScopeData();
*/	
	/*private static MyThreadScopeData instance = null;
	
	public static synchronized MyThreadScopeData getInstance(){
		if(null==instance){
			instance = new MyThreadScopeData();
		}
		return instance;
	}*/

    public static /*synchronized*/ MyThreadScopeData getThreadInstance() {
        MyThreadScopeData instance = map.get();
        if (null == instance) {
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }

    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
    private String name;
    private int age;

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