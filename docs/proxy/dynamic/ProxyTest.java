package com.labs.jdk5.proxy.dynamic;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * JDK动态代理，被代理类必须实现一个接口
 *
 * @author win10
 */
public class ProxyTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

        //获取代理类的参数为类加载器以及一组接口
        Class clazz = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        System.out.println(clazz.getName());
        System.out.println("begin constructors list --------");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            StringBuilder builder = new StringBuilder(name);
            Class[] params = c.getParameterTypes();
            builder.append("(");
            for (Class param : params) {
                builder.append(param.getName()).append(",");
            }

            if (params != null && params.length != 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append(")");
            System.out.println(builder.toString());
            //StringBuffer 线程安全
            //StringBuilder builder = new StringBuilder(name);
        }
        System.out.println("end constructors list --------");
        System.out.println("begin methods list --------");
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            String name = m.getName();
            StringBuilder builder = new StringBuilder(name);
            Class[] params = m.getParameterTypes();
            builder.append("(");
            for (Class param : params) {
                builder.append(param.getName()).append(",");
            }

            if (params != null && params.length != 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append(")");
            System.out.println(builder.toString());
            //StringBuffer 线程安全
            //StringBuilder builder = new StringBuilder(name);
        }
        System.out.println("end methods list --------");

        System.out.println("---- create instance ------");
        //clazz
        Constructor cp = clazz.getConstructor(InvocationHandler.class);

        class MyInvocationHandlerOne implements InvocationHandler {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }

        }

        //通过代理对象创建实例
		/*Collection px1 = (Collection)cp.newInstance(new MyInvocationHandlerOne());
		//System.out.println(px1);	//创建成功
		System.out.println(px1.toString());
		px1.clear();
		px1.size(); //调用有返回值的方法出现空指针异常 */ 
		
		/*Collection px1 = (Collection)cp.newInstance(new InvocationHandler(){
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return null;
			}
		});
		//System.out.println(px1);	//创建成功
		System.out.println(px1.toString());
		px1.clear();
		px1.size();//调用有返回值的方法出现空指针异常 
		 */
        System.out.println("------------ 合二为一 ------------");
		
		/*Collection px2 = (Collection)Proxy.newProxyInstance(Collection.class.getClassLoader(), 
				new Class[]{Collection.class}, 
				new InvocationHandler() {
					ArrayList target = new ArrayList();
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						for(Method m:proxy.getClass().getMethods()){
							System.out.println("--"+m.getName());
						}
						long beginTime = System.currentTimeMillis();
						Object retVal = method.invoke(target, args);
						long endTime =  System.currentTimeMillis();
						System.out.println(method.getName()+" TAKE: "+(endTime-beginTime));
						return retVal;
					}
				});
		
		System.out.println(px2.toString());
		px2.clear();
		px2.add("aaa");
		px2.add("bbb");
		System.out.println(px2.size());
		System.out.println(px2.getClass().getName());*/

        final ArrayList target = new ArrayList();
        Collection c = (Collection) getProxy(target, new MyAdvice());

        System.out.println(c.toString());
        c.clear();
        c.add("aaa");
        c.add("bbb");
        System.out.println(c.size());
        System.out.println(c.getClass().getName());


    }

    private static Object getProxy(final Object target, final Advice adv) {

        Object px3 = (Object) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						/*long beginTime = System.currentTimeMillis();
						Object retVal = method.invoke(target, args);
						long endTime =  System.currentTimeMillis();
						System.out.println(method.getName()+" TAKE: "+(endTime-beginTime));
						return retVal;*/
                        //long beginTime = System.currentTimeMillis();
                        adv.befor(method);
                        Object retVal = method.invoke(target, args);
                        //long endTime =  System.currentTimeMillis();
                        adv.after(method);
                        //System.out.println(method.getName()+" TAKE: "+(endTime-beginTime));
                        return retVal;
                    }
                });

        return px3;
    }
}
