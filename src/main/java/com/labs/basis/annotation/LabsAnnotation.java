package com.labs.basis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.labs.advenced.enums.WeekDay;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})

public @interface LabsAnnotation {
	
	/**
	 * 当只有value一个值需要设置，可以在注解中省略 [ 变量名= ],
	 */
	String value();

	/**
	 * defalut指定了该变量的默认值 
	 */
	String color() default "blue";
	
	/**
	 * 数组类型的变量，默认值由{}中的值列表指定
	 */
	int[] attr() default {};
	
	/**
	 * 枚举类型的变量
	 */
	WeekDay[] day() default {WeekDay.MONDAY};
	
	/**
	 * 注解形式的变量
	 */
	MetaAnnotation annoAttr() default @MetaAnnotation("DEF_VAL");
	
	/**
	 * Class类型的变量
	 * @return
	 */
	Class clazz();
}
