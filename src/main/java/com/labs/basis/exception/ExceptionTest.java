package com.labs.basis.exception;

import com.labs.basis.exception.ex.MyFileNotFoundException;
import com.labs.basis.exception.utils.Assert;

/**
 * @Description:
 * @Auther: win10
 * @Date: 2018/9/12 09:15
 */
public class ExceptionTest {

    public void methodWithoutThrows(){
        Object obj = null;
        Assert.isNull(obj,"OBJECT IS NULL");
    }

    public void methodWithThrows(){
        String fileName = "whatever";
        try{
            Assert.isFileExists(fileName,"Could not found: ");
        }catch (MyFileNotFoundException me){
            me.printStackTrace();
            me.getMessage();
        }
    }

    public static void main(String[] args) {
        ExceptionTest service = new ExceptionTest();
        service.methodWithThrows();
        service.methodWithoutThrows();

    }
}
