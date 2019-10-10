package me.buck.java8demo.test;

class Java8 {
    interface Logger {
        void log(String s);
    }

    public static void main(String... args) {
        sayHi(s -> System.out.println(s));
    }

    private static void sayHi(Logger logger) {
        logger.log("Hello!");
    }
}