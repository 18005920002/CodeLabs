package com.labs.jdk5.threads;

/**
 * ԭ���߳�Ҫ���еĻ��������Ƶ�һ������������
 *
 * @author win
 */
public class TraditionalThreadCommunication {

    public static void main(String[] args) {

        final Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 1; i <= 50; i++) {
					/*synchronized (TraditionalThreadCommunication.class) {
						 for(int j=1;j<=10;j++){
							System.out.println("sub:"+j+", loop of "+i);
						}
					}*/
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
			/*synchronized (TraditionalThreadCommunication.class) {
				for(int j=1;j<=10;j++){
					System.out.println("main:"+j+", loop of "+i);
				}
			}*/
            business.main(i);
        }

    }

}

class Business {
    private boolean bShouldSub = true;

    public synchronized void sub(int i) {
        while (!bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 10; j++) {
            System.out.println("sub:" + j + ", loop of " + i);
        }
        bShouldSub = false;
        this.notify();
    }

    public synchronized void main(int i) {
        //if(bShouldSub){
        while (bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 100; j++) {
            System.out.println("main:" + j + ", loop of " + i);
        }
        bShouldSub = true;
        this.notify();
    }

}