package com.labs.jdk5.app;

import com.labs.designpattern.strategy.compare.Person;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.Map.Entry;

public class GenericApp {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("k1", "ABCDEFG");
        //map.put("k1", "HIJKLMN");//key相同只保留一条
        map.put("k2", 123456);
        map.put("k3", 230.55d);
        Collection<String> keys = map.keySet();//不可重复
        //Collection<String> vals = map.values();
        Collection<Object> vals = map.values();

        Collection<Entry<String, Object>> entrys = map.entrySet();//不可重复
        for (Object k : keys) {
            System.out.println(k);
        }
        System.out.println("---------");
        for (Object v : vals) {
            System.out.println(v);
        }
        System.out.println("---------");
        for (Entry<String, Object> e : entrys) {
            System.out.println(e + " [" + e.getKey() + ":" + e.getValue() + "]");
        }

        GenericDao<Person> dao = new GenericDao<Person>();
        dao.add(new Person("xx", 12, 30000));
        Person s = dao.findById(1);
        System.out.println(s);


        Vector<Date> v1 = new Vector<Date>();
        Method method = GenericApp.class.getMethod("applyVector", Vector.class);
        Type[] types = method.getGenericParameterTypes();
        ParameterizedType ptype = (ParameterizedType) types[0];
        System.out.println("RawType:" + ptype.getRawType() + ",ActualType:" + ptype.getActualTypeArguments()[0]);
		/*for(Type t:tpyes){
			
		}*/
    }

    public static void applyVector(Vector<Date> v1) {

    }


}
