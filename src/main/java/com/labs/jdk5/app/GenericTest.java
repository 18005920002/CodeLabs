package com.labs.jdk5.app;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型
 * 泛型的类型只是在编译阶段给编译器使用,挡住非法输入,编译完后完全一样.
 *
 * @author win10
 */
public class GenericTest {


    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        ArrayList a1 = new ArrayList();
        a1.add("abc");
        a1.add(1);
        a1.add(2L);
        String s0 = (String) a1.get(0);
        //String s1 = (String)a1.get(1); //EXCEPTION

        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("def");
        //a2.add(1);
        //a2.add(2L);
        String s = a2.get(0);
        System.out.println(s0 + ":" + s);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(444);
        a3.add(555);
        //编译完的结果已经不带类型信息(去类型化)
        System.out.println("编译完不带类型信息(class字节码相同):" + (a2.getClass() == a3.getClass()));

        System.out.println("--绕过编译器存放不同类型的对象--");
        //a3.add("abc");	//往Integer类型的ArrayList放String类型的对象,编译器报错
        //绕过编译器,用反射方式,往Integer类型的ArrayList中放入String
        try {
            a3.getClass().getMethod("add", Object.class).invoke(a3, "AAA");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(a3.get(0));

        printCollection(a1);
        printCollection(a2);    //Collection<Object> coll
        printCollection(a3);    //Collection<Object> coll


        printCollection2(a1);
        printCollection2(a2);    //Collection<Object> coll
        printCollection2(a3);    //Collection<Object> coll

        printColl();
    }

    /**
     * 泛型通配符
     *
     * @param coll
     */
    public static void printCollection(Collection<?> coll) {

        //coll.add("xxx"); //使用泛型通配符就不能添加任意类型对象

        for (Object c : coll) {
            System.out.println(c);
        }
    }

    public static <T> void printCollection2(Collection<T> coll) {

        coll.add((T) "xxxXXX"); //使用泛型通配符就不能添加任意类型对象

        for (Object c : coll) {
            System.out.println(c);
        }
    }

    /**
     * 通配符的扩展,限定通配符总是包括自己
     * 限制通配符的上边界
     * Vector <? extends Number> v = new Vector<Integer>() 	//正确
     * Vector <? extends Number> v = new Vector<String>()  	//错误
     * 限制通配符的下边界
     * Vector <? super Integer> v = new Vector<Number>() 	//正确
     * Vector <? super Integer> v = new Vector<Byte>()		//错误
     */
    public static void printColl() throws Exception {
        Number n = Integer.valueOf(55555);

        Class<? extends Number> cls = Integer.class.asSubclass(Number.class);

        System.out.println(cls.getName() + ":" + cls.getSuperclass().getName());

    }


}
