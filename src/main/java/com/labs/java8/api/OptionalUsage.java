package com.labs.java8.api;

import java.util.Optional;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/18
 */
public class OptionalUsage {
    public static void main(String[] args) {

        Integer i = 5;
        if (i.equals(null)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }

        Optional<String> s = getString();
        if (s.isPresent()) {
            System.out.println(s.get());
        } else {
            System.out.println("String is null");
        }

        //System.out.println(s.get());
        System.out.println(s.orElse("Other"));
        System.out.println(s.orElseGet(() -> "OrElseGet"));
    }

    private static Optional<String> getString() {
        Optional o;
        // of方法不支持null，会直接抛错
        //o = Optional.of(null);
        // ofNullable支持空对象的包装，empty()与of的结合
        o = Optional.ofNullable(null);
        //o = Optional.of("Normal Text");
        o = Optional.empty();

        return o;
    }
}
