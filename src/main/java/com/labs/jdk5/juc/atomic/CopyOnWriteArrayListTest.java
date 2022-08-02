package com.labs.jdk5.juc.atomic;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(new DR()).start();
        }
    }
}

class DR implements Runnable {

    //private List<String> list =
    //		Collections.synchronizedList(new ArrayList<String>());
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("aa");
        list.add("bb");
        list.add("cc");
    }

    @Override
    public void run() {
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
            list.add("XX");
        }
    }
}
