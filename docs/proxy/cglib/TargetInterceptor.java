package com.labs.jdk5.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TargetInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {

        System.out.println("BEFORE::::");
        //proxy.invoke(arg0, arg1)
        Object result = proxy.invokeSuper(obj, params);
        System.out.println("AFTER:::::");
        return result;
    }

}
