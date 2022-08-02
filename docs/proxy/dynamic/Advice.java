package com.labs.jdk5.proxy.dynamic;

import java.lang.reflect.Method;

public interface Advice {
    public void befor(Method m);

    public void after(Method m);
}
