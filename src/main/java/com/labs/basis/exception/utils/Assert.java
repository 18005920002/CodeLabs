package com.labs.basis.exception.utils;

import com.labs.basis.exception.ex.MyFileNotFoundException;

import java.io.*;

/**
 * @Description: 异常处理
 * @Auther: win10
 * @Date: 2018/9/12 09:17
 */
public class Assert {

    public static void isNull(Object obj,String msg) {

        // IllegalArgumentException非检查异常
        // 方法不需要用try{}catch(){}处理，也不用在方法声明中用throws抛出
        if(null==obj){
            throw new IllegalArgumentException(msg);
        }

    }

    public static void isFileExists (String fileName, String msg) throws MyFileNotFoundException{

        // MyFileNotFoundException 是自定义得检查异常
        // 方法不需可以用try{}catch(){}处理；
        // 也可以不处理，throw 到外层，但是需要在方法声明中用throws抛出，让外层来处理
        File file = new File(fileName);
        if(!file.exists()){
            throw new MyFileNotFoundException(msg + fileName);
        }
    }

}
