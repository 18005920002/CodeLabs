package com.labs.jdk5.juc.traditional;

public class TraditionalThreadSynchronized {

    public static void main(String[] args) {
        new TraditionalThreadSynchronized().init();
    }

    private void init() {
        final Outputer op = new Outputer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //op.output("zhangxiaoxiang");
                    op.output3("zhangxiaoxiang");
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    op.output2("lihuoming");
                }
            }
        });
        t2.start();
    }

    /*class Outputer{
        void output(String s){
            synchronized(this){
            for(int i=0;i<s.length();i++){
                System.out.print(s.charAt(i));
            }
            System.out.println();
            }
        }
    }*/
    static class Outputer {
        synchronized void output(String s) {
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
        }

        void output2(String s) {
            synchronized (Outputer.class) {
                for (int i = 0; i < s.length(); i++) {
                    System.out.print(s.charAt(i));
                }
                System.out.println();
            }
        }

        static synchronized void output3(String s) {
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
        }
    }
}
