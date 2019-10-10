package me.buck.java8demo.share;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by gwf on 2019/10/10
 */
public class Java8CompletableFuture {

    public static void main(String[] args) {

        CompletableFuture
                .supplyAsync(() -> {
                    // do some  thing
                    // do some  thing
                    // do some  thing
                    // do some  thing
                    // do some  thing
                    // do some  thing

                    return "string";
                }, Exs.IO)
                .thenAcceptAsync(s -> {
                    // do some  thing
                    System.out.println(s);
                }, Exs.UI);

    }

    public static class Exs {

        public static Executor IO = Executors.newSingleThreadExecutor();

        public static Executor UI = new Executor() {

            Handler mHandler = new Handler(Looper.getMainLooper());

            @Override
            public void execute(Runnable command) {
                mHandler.post(command);
            }
        };
    }



}
