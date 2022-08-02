package com.labs.java8.stream;

import com.beust.jcommander.internal.Lists;
import com.labs.java8.lambda.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1. 创建流
 * 2. 中间操作
 * 3. 终止操作
 *
 * @Author: tanyun.zheng
 * @Date: 2020/4/7
 */
public class StreamAPI {


    public static void main(String[] args) {
        StreamAPI api = new StreamAPI();
        //api.getStream();
        api.opFilter();
        api.opMap();
    }

    List<Employee> employeeList = Arrays.asList(
            Employee.builder().age(18).name("zhangsan").salary(3333.33).build(),
            Employee.builder().age(49).name("lisi").salary(4444.44).build(),
            Employee.builder().age(35).name("wangwu").salary(6666.66).build(),
            Employee.builder().age(25).name("zhaoliu").salary(2222.22).build(),
            Employee.builder().age(35).name("xiaoliu").salary(1111.11).build(),
            Employee.builder().age(45).name("tianqi").salary(5555.55).build()
    );

    public void getStream() {
        //Collection
        List<String> stringList = Lists.newArrayList();
        Stream<String> stringStream = stringList.stream();

        //数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> employeeStream = Arrays.stream(emps);

        //of方法
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //无限流
        Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2);
        integerStream.limit(4).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
    }

    public void opFilter() {
        Stream empStream = employeeList.stream().filter((e) -> e.getAge() > 35);
        //终止操作
        empStream.forEach(System.out::println);
    }

    public void opMap() {
        employeeList.stream().map(Employee::getAge).forEach(System.out::println);
    }

}
