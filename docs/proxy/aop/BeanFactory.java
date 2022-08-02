package com.labs.jdk5.proxy.aop;

import com.labs.advenced.proxy.dynamic.Advice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BeanFactory {
    Properties props = new Properties();

    public BeanFactory(InputStream ins) {
        try {
            props.load(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String name) {
        String className = props.getProperty(name);
        Object bean = null;
        Object proxy = null;
        try {
            Class clazz = Class.forName(className);
            bean = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (bean instanceof ProxyFactoryBean) {
            //创建代理对象
            ProxyFactoryBean fbean = (ProxyFactoryBean) bean;
            try {
                Advice advice = (Advice) Class.forName(props.getProperty(name + ".advice")).newInstance();
                Object target = Class.forName(props.getProperty(name + ".target")).newInstance();

                fbean.setAdvice(advice);
                fbean.setTarget(target);
                proxy = fbean.getProxy();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return proxy;
        }
        return bean;
    }
}
