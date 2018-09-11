package com.labs.basis.annotation;

import com.labs.advenced.enums.WeekDay;

@LabsAnnotation(clazz=String.class,value="xx",attr={1,2,3},annoAttr=@MetaAnnotation("anno")/*,day={WeekDay.SATURDAY,WeekDay.SUNDAY}*/)
public class AnnotationTest {
	
	public static void main(String[] args) {
		if(AnnotationTest.class.isAnnotationPresent(LabsAnnotation.class)){
			LabsAnnotation la = (LabsAnnotation)AnnotationTest.class.getAnnotation(LabsAnnotation.class);
			System.out.println(la.color());
			System.out.println(la.value());
			System.out.println(la.attr().length);
			System.out.println(la.day()[0].toString());
			System.out.println(la.annoAttr().value());
			System.out.println(la.clazz().getName());
		}else{
			
		}
	}
}
