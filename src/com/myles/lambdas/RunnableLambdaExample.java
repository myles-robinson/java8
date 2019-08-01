package com.myles.lambdas;

public class RunnableLambdaExample {

    public static void main(String[] args) {

        /**
         * Before Java 8
         */

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 1");
            }
        };

        new Thread(runnable).start();

        /**
         * Java 8 Lambdas
         */
        // () -> {};

        Runnable runnableLambda = () -> System.out.println("Inside runnable Lambda");

        Runnable multiLine = () -> {
            System.out.println("Line 1");
            System.out.println("Line 2");
        };

        new Thread(multiLine).start();

        new Thread(runnableLambda).start();

        new Thread(() -> System.out.println("Inside Anonymous Lambda"));
    }

}
