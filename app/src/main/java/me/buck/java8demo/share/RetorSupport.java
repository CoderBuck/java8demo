package me.buck.java8demo.share;

import java.util.Arrays;
import java.util.List;

import java9.util.stream.Collectors;
import java9.util.stream.StreamSupport;

/**
 * Created by gwf on 2019/10/10
 */
public class RetorSupport {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> collect = StreamSupport.stream(list)
                .filter(integer -> integer > 5)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);


    }
}
