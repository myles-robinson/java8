package com.myles.optional;

import java.util.Optional;

public class OptionalOfEmptyNullableExample {

    public static void main(String[] args) {
        System.out.println(ofNullable().isPresent());
        of().ifPresent(s -> System.out.println(of().get()));
        System.out.println(empty());
    }

    static Optional<String> ofNullable() {

        Optional<String> stringOptional = Optional.ofNullable("Nullable Hello");
        return stringOptional;
    }

    static Optional<String> of() {
       return Optional.of("Optional of Nullable Hello"); // always requires a value
    }

    static Optional<String> empty() {
        return Optional.empty();
    }
}
