package com.labs.basis.exception.ex;

/**
 * @Description
 * @author win10
 * @Date 2018/9/12 10:22
 */
public class MyFileNotFoundException extends Exception {

    private String msg;

    public MyFileNotFoundException(){
        super();
    }

    public MyFileNotFoundException(String msg){
        this.msg = msg;
    }

    public String getMessage(){
        return "::::::" + msg;
    }
}
