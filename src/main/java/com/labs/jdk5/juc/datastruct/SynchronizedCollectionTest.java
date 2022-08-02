package com.labs.jdk5.juc.datastruct;

/**
 * HashSet内部使用的是HashMap
 * <p>
 * HashMap
 *
 * @author win10
 */
public class SynchronizedCollectionTest {

    public static void main(String[] args) {

    }

}

class User {
    String name;

    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}