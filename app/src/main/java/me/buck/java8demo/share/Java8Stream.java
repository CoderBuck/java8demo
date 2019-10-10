package me.buck.java8demo.share;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by gwf on 2019/10/10
 */
public class Java8Stream {

    public static void main(String[] args) {
        //test1();
        test2();
    }


    static void test1() {
        //Stream.of(1, 2, 3)
        //        .forEach(System.out::println);
        //
        //List<Integer> list = Arrays.asList(1, 2, 3);
        //
        //Stream.of(list).forEach(System.out::println);
        //
        //list.stream()
        //        .forEach(System.out::println);

        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println(sum);

    }

    static void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.stream()
                .filter(integer -> integer > 1)
                .filter(integer -> integer > 2)
                .filter(integer -> integer > 3)
                .filter(integer -> {
                    boolean b = integer % 2 == 0;
                    if (b) {
                        System.out.println("integer % 2 == 0 : " + integer);
                    }
                    return b;
                })
                .map(integer -> integer + 10)
                .forEach(integer -> System.out.println("forEach : " + integer));

        List<Integer> collect = list.stream()
                .filter(integer -> integer > 3)
                .collect(Collectors.toList());

    }

}
