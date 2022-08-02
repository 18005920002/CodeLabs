package com.labs.designpattern.chain;

import java.util.ArrayList;

/**
 * Concreate Handler
 *
 * <p>Title: Shanghai</p>
 * <p>Description: </p>
 * <p>www.labs.com</p>
 *
 * @author win
 * @version 1.0
 */
public class Shanghai implements Handler {

    private Handler handler;

    private ArrayList<String> numberList = new ArrayList<String>();

    public Shanghai() {
        numberList.add("21102981234930034");
        numberList.add("21102981234930035");
        numberList.add("21102981234930036");
        numberList.add("21102981234930037");
    }

    @Override
    public void handleRequest(String number) {
        System.out.println("上海节点检查:");
        if (numberList.contains(number)) {
            System.out.println("该号码属于上海");
            return;
        } else {
            System.out.println("该号码不属于上海");
            //交给下一个handler
            if (handler != null) {
                handler.handleRequest(number);
            }
        }
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }

}
