package me.buck.java8demo.share;

import android.view.View;

/**
 * Created by gwf on 2019/10/10
 */
public class Java8Lambda {

    Runnable mRunnable = () -> {
        System.out.println("hello");
        System.out.println("world");

        // 限制：不能引用自己 mRunnable
    };

    View.OnClickListener mOnClickListener = v -> System.out.println("onClick");
    View.OnClickListener mOnClickListener2 = this::method;

    public static void main(String[] args) {

    }


    void method(View view) {

    }

}
