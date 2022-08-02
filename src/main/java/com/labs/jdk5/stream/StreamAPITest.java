package com.labs.jdk5.stream;

import com.labs.jdk5.lambda.Employee;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.labs.jdk5.lambda.Employee.Status.*;

/**
 * 1. 创建流，将数据源转为流
 * 2. 中间操作
 * 3. 终止操作，产生新的流，数据源不受影响
 *
 * @author win10
 */
public class StreamAPITest {

    List<Employee> emps;

    public StreamAPITest() {
        emps = Arrays.asList(
                new Employee("zhangsan", 18, 9999.99, FREE),
                new Employee("lisi", 42, 5999.99, FREE),
                new Employee("wangwu", 33, 3999.99, FREE),
                new Employee("wangwu", 38, 3999.99, VOCATION),
                new Employee("wangwu", 31, 3999.99, FREE),
                new Employee("zhaoliu", 25, 4999.99, BUSY),
                new Employee("tianqi", 15, 2999.99, FREE)
        );
    }

    public static void main(String[] args) {
        //通过Collection系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //通过Arrays的静态方法stream获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);


        //通过Stream的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //创建无限流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        //迭代
        stream4.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
    }

    //中间操作

    /**
     * filter
     * limit
     * skip(n)
     * distinct 根据Hashcode和equals去重
     */
    @Test
    public void filter() {
		/*
		Stream<Employee> stemp = emps.stream().filter((e) -> e.getAge()>30);//中间操作，没有执行，属于延迟加载
		stemp.forEach(System.out::println);//终止操作，触发后才一次性执行全部中间操作。（惰性求值）
		*/
        //内部迭代，通过forEach完成
        //emps.stream().filter((e) -> e.getAge()>35).forEach(System.out ::println);
    }

    @Test
    public void limit() {
        //emps.stream().filter((e) -> {System.out.println("短路");return e.getAge()>30;}).limit(1).forEach(System.out ::println);
    }

    @Test
    public void skipAndDistinct() {
		/*emps.stream().filter((e) -> e.getAge()>30)
			.skip(2)
			.distinct()	//以equals和hashCode作为筛选依据
			.forEach(System.out ::println);	*/
    }

    /**
     * map 接收一个Lambda，将元素转换成其他元素或提取信息，接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap 接收一个函数作为参数，将流中的每个值都转成另一个流，然后把所有流连接成一个流。
     */
    @Test
    public void testMapAndFlatMap() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "dddd", "eee");
        //list.stream().map(e -> e.toUpperCase()).forEach(System.out::println);

        //emps.stream().map(e->e.getName()).forEach(System.out::println); //提取姓名
		
		/*Stream<Stream<Character>> stream = list.stream().map(StreamAPITest::filterCharacter);
		stream.forEach(s->s.forEach(System.out::println));*/
		
		/*
		list.stream().flatMap(StreamAPITest::filterCharacter).forEach(System.out::println);
		*/
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /**
     * sorted 自然排序，Comparable.compareTo(...)
     * sorted(Comparator c) 定制排序，Comaprator
     */
    @Test
    public void testSort() {
        /**
         * 自然排序，String实现Comapable接口，按照其compareTo()方法排
         */
		/*List<String> list  = Arrays.asList("ccc","eee","aaa","ddd","bbb");
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println("----------");
		emps.stream()
		.sorted((e1,e2)-> e1.getAge() - e2.getAge()) //按年龄排
		.forEach(System.out::println);*/
    }


    @Test
    public void testFindAndMatch() {
		
	/*	boolean b1 = emps.stream().allMatch(e->e.getStatus().equals(Status.BUSY));
		System.out.println("allMatch："+b1);
		boolean b2 = emps.stream().anyMatch(e->e.getStatus().equals(Status.BUSY));
		System.out.println("anyMatch："+b2);
		boolean b3 = emps.stream().noneMatch(e->e.getStatus().equals(Status.BUSY));
		System.out.println("noneMatch："+b3);
		
		//避免空指针异常
		Optional<Employee> op = emps.stream()
				.sorted((e1,e2)-> Double.compare(e1.getSalary(), e2.getSalary()))
				.findFirst();
		op.orElse(other)
		System.out.println(op.get());
		//并行流
		Optional<Employee> op2 = emps.parallelStream()stream().filter(e->e.getStatus().equals(Status.FREE)).findAny();
		System.out.println(op2.get());
		*/
		
		/*Long count = emps.stream().count();
		System.out.println("Count:"+count);
		
		Optional<Employee> op = emps.stream()
				.max((e1,e2)->Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println("max salary person:"+op.get());
		
		Optional<Double> op2 = emps.stream().map(Employee::getSalary).min(Double::compare);
		System.out.println("min salary:"+op2.get());*/
    }

    /**
     * 规约
     */
    @Test
    public void testReduce() {
		/*List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer sum= list.stream().reduce(0, (x,y)->x+y);
		System.out.println("Sum="+sum);
		
		//累计计算工资综合，有可能为空的封装到optional
		Optional<Double> op = emps.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println("Salary Sum:"+op.get());*/
    }

    /**
     * 收集
     */
    @Test
    public void collect() {
		/*//提取名字放在集合中
		List<String> list = emps.stream().map(Employee::getName).collect(Collectors.toList()); 
		list.stream().forEach(System.out::println);
		//提取名字放在Set中，去重
		System.out.println("----------");
		Set<String> set = emps.stream().map(Employee::getName).collect(Collectors.toSet()); 
		set.stream().forEach(System.out::println);
		//提取名字到特殊的集合中
		System.out.println("----------");
		HashSet<String> hashSet = emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new)); 
		hashSet.stream().forEach(System.out::println);
		System.out.println("----------");
		Long count = emps.stream().collect(Collectors.counting());
		System.out.println("Count:"+count);
		Double average = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("Avg Salary:"+average);
		Double sumSalary = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("sum Salary :"+sumSalary);
		Optional<Employee> empMax = emps.stream().collect(Collectors.maxBy((e1,e2)->Double.compare(e1.getSalary(), e1.getSalary())));
		System.out.println("max salary employee:"+empMax.get());
		Optional<Double> minSalary = emps.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compareTo));
		System.out.println("min Salary :"+minSalary.get());*/
    }

    /**
     * 分组
     */
    @Test
    public void group() {
		/*Map<Status,List<Employee>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(map);*/

        //多级分组
		/*Map<Status,Map<String,List<Employee>>> map2 = emps.stream()
		.collect(Collectors.groupingBy(Employee::getStatus,
				Collectors.groupingBy((e)->{
					if(e.getAge()<=35){
						return "YONG";
					}else{
						return "OLD";
					}
				})));
		System.out.println(map2);*/

    }

    /**
     * 分片/分区及其他
     */
    @Test
    public void testPartitionAndOther() {
        Map<Boolean, List<Employee>> map =
                emps.stream()
                        .collect(Collectors.partitioningBy(e -> e.getSalary() > 5000));
        System.out.println(map);

        //返回一个统计对象
        DoubleSummaryStatistics dss = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getAverage());

        String sname = emps.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(sname);
    }


}
