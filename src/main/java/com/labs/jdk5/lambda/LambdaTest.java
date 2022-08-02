package com.labs.jdk5.lambda;

import java.util.*;

/**
 * Lambda表达式引入->操作符，将lambda表达式分为两部分
 * Lambda表达式需要函数式接口的支持，（接口中只有一个抽象方法称为函数式接口）可以使用@FunctionalInterface修饰
 * 左边：lambda表达式的参数列表（接口中参数列表）
 * 右边：lambda体，需要实现的功能
 * <p>
 * 语法格式1：无参数，无返回值
 * () -> System.out.println();
 * <p>
 * 语法格式2：一个参数，无返回值
 * (x) -> System.out.println();
 * x  -> System.out.println(); //小括号括约省略
 * <p>
 * 语法格式3：有两个及以上的参数，且labmda体有多条语句，有返回值
 * (x,y) -> {System.out.println();System.out.println();}
 * Comparator<Integer> comparator = (x,y) -> {
 * System.out.println();
 * return Integer.compare(o1, o2);
 * }
 * <p>
 * 语法格式4：如果只有一条语句，return 和 {} 都可以省略
 * Comparator<Integer> comparator = (x,y) -> Integer.compare(o1, o2);
 * <p>
 * 语法格式5：参数类型可以省略不写，Java编译器可以进行类型推断
 * Comparator<Integer> comparator = (Integer x,Integer y) -> Integer.compare(o1, o2);
 *
 * @author win10
 */

public class LambdaTest {
    public static void main(String[] args) {

        /**
         * 匿名内部类
         */
		/*Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};*/
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<Integer>(comparator);


        List<Employee> emps = Arrays.asList(
                new Employee("zhangsan", 18, 9999.99),
                new Employee("lisi", 42, 5999.99),
                new Employee("wangwu", 33, 3999.99),
                new Employee("wangwu", 38, 3999.99),
                new Employee("wangwu", 31, 3999.99),
                new Employee("zhaoliu", 25, 4999.99),
                new Employee("tianqi", 15, 2999.99)
        );

        /**
         * Lambda表达式在简化匿名内部类的应用
         */
		/*List<Employee> xs = new LambdaTest().findEmplyees(emps, new FilterStrategy() {
			@Override
			public boolean meetRequire(Employee emp) {
				return emp.getSalary()>3000;
			}
		});*/
        //List<Employee> xs = new LambdaTest().findEmplyees(emps, x -> x.getSalary()>4000);
/*		List<Employee> xs = new LambdaTest().findEmplyees(emps, x -> x.getAge()>30);

		for(Employee x:xs){
			System.out.println(x);
		}
*/
        /**
         * -----------------------------
         * 实现比较功能，姓名一样按照年龄比较
         * ::::IDE还不够智能，可以先用匿名内部类的方式先写，或者换更高版本。::::
         */
		/*Collections.sort(emps, (o1, o2) -> {
			if (o1.getName() == o2.getName()) {
				if (o1.getAge() < o2.getAge()) {
					return -1;
				}
			}
		return 0;});*/
        Collections.sort(emps, (o1, o2) -> {
            if (o1.getName() == o2.getName()) {
                return Integer.compare(o1.getAge(), o2.getAge());
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Employee x : emps) {
            System.out.println(x);
        }


        new LambdaTest().getResult(100L, 100L, (a, b) -> (Long) a + (Long) b);
        //System.out.println(x);

    }

    public List<Employee> findEmplyees(List<Employee> list, FilterStrategy fs) {
        List<Employee> ok = new ArrayList<Employee>();
        for (Employee emp : list) {
            if (fs.meetRequire(emp))
                ok.add(emp);
        }
        return ok;
    }


    public void sort(List<Employee> emps) {
        Collections.sort(emps, (o1, o2) -> {
            if (o1.getName() == o2.getName()) {
                if (o1.getAge() < o2.getAge()) {
                    return -1;
                }
            }
            return 0;
        });
		/*Collections.sort(emps,new Comparator<Employee>() {@Override
		public int compare(Employee o1, Employee o2) {
			if(o1.getName()==o2.getName()){
				if(o1.getAge()<o2.getAge()){
					return -1;
				}
			}
			return 0;
		}
		});*/

        for (Employee x : emps) {
            System.out.println(x);
        }
    }

    public void getResult(Long a, Long b, MyFunInterface m) {
        //return (Long)m.getValue(a, b);
        System.out.println(m.getValue(a, b));
    }

}
