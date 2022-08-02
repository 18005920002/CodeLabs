package com.labs.guava.coll;

import com.google.common.base.Optional;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/7/18
 */
@Slf4j
public class GuavaOptionalUsage {
    public static void main(String[] args) {
        Optional<String> os = getString();
        if (os.isPresent()) {
            log.info(os.get());
        } else {
            log.info("String is null");
        }
    }

    private static Optional<String> getString() {
        //error
        //Optional<String> o = Optional.of(null);

        //类似JDK的ofNullable，或者 empty()
        Optional<String> o = Optional.absent();

        // 类似absent()
        o = Optional.fromNullable(null);

        //
        o = Optional.of("Normal String");

        return o;
    }
}
