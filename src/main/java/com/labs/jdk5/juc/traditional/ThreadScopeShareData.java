package com.labs.jdk5.juc.traditional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {

	/*private static int data = 0;

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					//int x = new Random().nextInt();
					//System.out.println(Thread.currentThread().getName()+" generate int "+x);
					try {
						Thread.sleep(new Random().nextInt(100));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + ": has put data " + data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		public int get() {
			System.out.println("A from " + Thread.currentThread().getName() + ": get data " + data);
			return data;
		}
	}

	static class B {
		public int get() {
			System.out.println("B from " + Thread.currentThread().getName() + ": get data " + data);
			return data;
		}
	}
	*/
	/*
	Thread-0 generate int -941167312
	Thread-1 generate int 1055863995
	Thread-1: has put data 1055863995
	Thread-0: has put data -941167312
	A from Thread-1: get data 1055863995
	A from Thread-0: get data 1055863995
	B from Thread-0: get data 1055863995
	B from Thread-1: get data 1055863995*/

    //private static int data = 0;
    private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
					/*try {
						Thread.sleep(new Random().nextInt(100));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
                    int data = new Random().nextInt();

                    System.out.println(Thread.currentThread().getName() + ": has put data " + data);
                    threadData.put(Thread.currentThread(), data);

                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public int get() {
            int data = threadData.get(Thread.currentThread());
            System.out.println("A from " + Thread.currentThread().getName() + ": get data " + data);
            return data;
        }
    }

    static class B {
        public int get() {
            int data = threadData.get(Thread.currentThread());
            System.out.println("B from " + Thread.currentThread().getName() + ": get data " + data);
            return data;
        }
    }

}
