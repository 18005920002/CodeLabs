package com.labs.jdk5.threads;

public class TraditionalThread {
    public static void main(String[] args) {
		/*Thread thread = new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500); //sleep�ڼ䲻ռ��CPU
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
			}
		};
		thread.start();
		
		
		Thread thread2 = new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500); //sleep�ڼ䲻ռ��CPU
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
			}
		});
		thread2.start();
	*/
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500); //sleep�ڼ䲻ռ��CPU
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("R:" + Thread.currentThread().getName());
                }
            }
        }) {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500); //sleep�ڼ䲻ռ��CPU
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T:" + Thread.currentThread().getName());
                }
            }

            ;
        }.start();
    }


}
