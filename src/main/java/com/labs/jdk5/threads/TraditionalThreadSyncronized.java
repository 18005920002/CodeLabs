package com.labs.jdk5.threads;

public class TraditionalThreadSyncronized {

    public static void main(String[] args) {
        new TraditionalThreadSyncronized().init();
    }

    private void init() {
        //��̬�����в���new�ڲ����ʵ������
        final Outputer op = new Outputer();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    op.output("zhangsan");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }) {
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    op.output3("longlisi");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }) {
        }.start();
    }

    //�ڲ�����Է����ⲿ��ĳ�Ա����
    static class Outputer {
        //final String xxx="";
        public void output(String name) {   //ͬ������
            int len = name.length();
            synchronized (/*name*//*xxx*//*this*/Outputer.class) {        //ͬ������飬����Ϊͬһ������
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }


        public synchronized void output2(String name) {   //ͬ������
            int len = name.length();
            //synchronized (/*name*//*xxx*/this) {		//ͬ������飬����Ϊͬһ������
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
            //}
        }

        public static synchronized void output3(String name) {   //ͬ������
            int len = name.length();
            //synchronized (/*name*//*xxx*/this) {		//ͬ������飬����Ϊͬһ������
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
            //}
        }
    }
}
