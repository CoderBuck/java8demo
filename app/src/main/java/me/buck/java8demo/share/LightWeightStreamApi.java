package me.buck.java8demo.share;


import com.annimon.stream.Stream;

/**
 * Created by gwf on 2019/10/10
 */
public class LightWeightStreamApi {

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(integer -> integer % 2 == 0)
                .toList();
    }
}
