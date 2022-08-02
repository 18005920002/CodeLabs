package com.labs.basis.exception;

import com.labs.basis.exception.ex.MyFileNotFoundException;
import com.labs.basis.exception.utils.Assert;

/**
 * Description 异常测试
 * Throwable 类
 * + Error  代表了JVM本身的错误。错误不能被程序员通过代码处理
 * + Exception 代表程序运行时发送的各种不期望发生的事件
 * <p>
 * - CHECK 除了Error 和 RuntimeException的其它异常，javac强制要求程序员为这样的异常做预备处理工作（使用try…catch…finally或者throws）
 * (IOException, EOFException,FileNotFoundException)
 * <p>
 * - UNCHECK Error 和 RuntimeException 以及他们的子类
 * ( Error,VitrualMachineError,StackOverFlowError,OutOfMemoryError,AWTError.
 * RuntimeException,ArrithmeticException,MissingResourceException,ClassNotFoundException,NullPointerException, IllegalArgumenetException,ArrayIndexOutOfBoundException,UnknownTypeExcception)
 *
 * @author win10
 * @Date 2018/9/12 09:15
 */
public class ExceptionTest {

    public void methodWithoutThrows() {
        Object obj = null;
        Assert.isNull(obj, "OBJECT IS NULL");
    }

    public void methodWithThrows() {
        String fileName = "whatever";
        try {
            Assert.isFileExists(fileName, "Could not found: ");
        } catch (MyFileNotFoundException me) {
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
