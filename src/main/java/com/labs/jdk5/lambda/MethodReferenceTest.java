package com.labs.jdk5.lambda;

import java.util.function.Consumer;

public class MethodReferenceTest {
    public static void main(String[] args) {
        Consumer<String> con = (x) -> System.out.println(x);

        System.out.println();
    }
}
