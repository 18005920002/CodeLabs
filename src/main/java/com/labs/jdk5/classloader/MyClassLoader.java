package com.labs.jdk5.classloader;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        String srcPath = "E:\\workspace\\source_labs\\advanced_java5\\bin\\com\\labs\\advenced\\classloader\\ClassLoaderAttchment.class";//args[0];
        String destPath = "E:\\workspace\\source_labs\\advanced_java5\\cypher";//args[1];
        String destFileName = "E:\\workspace\\source_labs\\advanced_java5\\cypher\\ClassLoaderAttchment.class";
        FileInputStream fins = new FileInputStream(srcPath);
        FileOutputStream fos = new FileOutputStream(destFileName);
        cypher(fins, fos);
        fins.close();
        fos.close();
    }

    /**
     * 对称加密
     *
     * @param ins
     * @param os
     * @throws Exception
     */
    public static void cypher(InputStream ins, OutputStream os) throws Exception {
        int b = -1;
        while ((b = ins.read()) != -1) {
            os.write(b ^ 0xff);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        //return super.findClass(name);
        String fileName = classPath + "\\" + name + ".class";
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            cypher(fis, bos);
            fis.close();
            byte[] bytes = bos.toByteArray();
            return defineClass(bytes, 0, bytes.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private String classPath;

    public MyClassLoader() {
    }

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }


}
