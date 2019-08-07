package com.myles.optional;

import java.util.Optional;

public class OptionalPresentExample {

    public static void main(String[] args) {

        //isPresent
        Optional<String> optional = Optional.of("Hello Optional");
        System.out.println(optional.isPresent());
    }
}
