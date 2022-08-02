package com.labs.jdk5.juc.lock;

/**
 * 1. 两个普通同步方法，两个线程标准打印
 * Thread-0:one
 * Thread-1:two
 * <p>
 * 2. 增加Thread.sleep()在getOne()
 * Thread-0:one
 * Thread-1:two
 * <p>
 * 3. 增加getThree()
 * Thread-0:one
 * Thread-2:three
 * Thread-1:two
 * <p>
 * 4.两个对象的普通同步方法
 * Thread-1:two
 * Thread-0:one
 * <p>
 * 5.静态同步方法
 * Thread-1:two
 * Thread-0:one
 * <p>
 * 6.两个静态同步方法
 * Thread-0:one
 * Thread-1:two
 * <p>
 * 7.静态和非静态，两个对象
 * Thread-1:two
 * Thread-0:one
 * <p>
 * 8.两个静态同步方法，两个对象
 * Thread-0:one
 * Thread-1:two
 * <p>
 * 1.非静态方法的锁默认为this
 * 2.静态方法的锁默认为Class实例
 * 3.在某个时刻只能有一个线程持有锁，其他线程拿不到锁
 *
 * @author win10
 */
public class Thread8LockTest {
    public static void main(String[] args) {
        Number n = new Number();
        Number n2 = new Number();
        new Thread(new Runnable() {
            @Override
            public void run() {
                n.getOne();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                n2.getTwo();
            }
        }).start();
		/*new Thread(new Runnable() {
			@Override
			public void run() {
				n.getThree();
			}
		}).start();*/
    }
}

class Number {
    public static synchronized void getOne() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":one");
    }

    public static synchronized void getTwo() {
        System.out.println(Thread.currentThread().getName() + ":two");
    }

    public synchronized void getThree() {
        System.out.println(Thread.currentThread().getName() + ":three");
    }
}
