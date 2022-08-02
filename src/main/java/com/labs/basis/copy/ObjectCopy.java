package com.labs.basis.copy;

import com.labs.basis.copy.vo.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象拷贝
 *
 * @author win10
 * @version v1.0 2018/11/30 14:26
 */
public class ObjectCopy {

    public void test() {
        Student s = new Student();
        s.setAge(10);
        s.setName("XXXX");
        copyStudent(s);
    }

    public void copyStudent(Student s) {
        List<Student> stuList = new ArrayList<Student>();

        for (int i = 0; i < 5; i++) {
            Student newStudent = new Student();
            newStudent.setName(s.getName());
            newStudent.setAge(10 + i);
            stuList.add(newStudent);
        }
        for (Student sx : stuList) {
            System.out.println(sx.getAge() + ":" + s.getName());
        }
    }

    public static void main(String[] args) {
        new ObjectCopy().test();
    }
}
