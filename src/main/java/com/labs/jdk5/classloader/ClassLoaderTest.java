package com.labs.jdk5.classloader;

import java.util.Date;

public class ClassLoaderTest {

    public static void main(String[] args) {
        //AppClassLoader:加载classpath指定的类
        //String loaderName = ClassLoaderTest.class.getClassLoader().getClass().getName();
        //System.out.println(loaderName);

        //ExtClassLoader:加载jre/lib/ext/*.jar
        //System.out.println(ECKeyFactory.class.getClassLoader().getClass().getName());

        //BootStrap:加载jre/lib/rt.jar
		/*loaderName = System.class.getClassLoader().getClass().getName();
		System.out.println(loaderName);*/


        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        while (null != loader) {
            System.out.println(loader.getClass().getName());
            loader = loader.getParent();
        }
        System.out.println(loader);

        //类加载器的委托机制
        //当前线程的类

        //加载类
        //System.out.println(new ClassLoaderAttchment().toString());
        try {
            Class cla = new MyClassLoader("E:\\workspace\\source_labs\\advanced_java5\\cypher").loadClass("ClassLoaderAttchment");
            Date d = (Date) cla.newInstance();

            System.out.println(cla.newInstance().toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
 