package me.buck.java8demo.share;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by gwf on 2019/10/10
 */
public class SkyWalkerLambdaReplaceReflect {

    // Consumer java8提供，可以自己写接口代替
    private Map<String, Consumer<String>> handlerMap = new HashMap<>();

    public  void init() {
        // 优势 1. 代码智能提示  2.直接关联方法方便跳转  3. 不需要new 对象，清晰简洁
        handlerMap.put("1", this::onMsg1);
        handlerMap.put("2", this::onMsg2);
        handlerMap.put("3", this::onMsg3);

        //匿名内部类冗长
        //handlerMap.put("3", new Consumer<String>() {
        //    @Override
        //    public void accept(String s) {
        //        onMsg3(s);
        //    }
        //});



        // 对比反射
        //handlerMap.put("1", "onMsg1");
        //handlerMap.put("2", "onMsg2");
        //handlerMap.put("3", "onMsg3");
    }

    public void onMsg1(String s) { }

    public void onMsg2(String s) { }

    public void onMsg3(String s) { }


    /**
     * 处理入口
     */
    public void handler(String msg) {
        Consumer<String> consumer = handlerMap.get(msg);
        if (consumer != null) {
            consumer.accept(msg);
        }

        // 对比通过反射
        //methodName = broadcastHandler.get(methodName);
        //try {
        //    Class<?> classObj = BaseActivity.this.getClass();
        //    final Method method = classObj.getDeclaredMethod(methodName, Intent.class);
        //    if (method != null) {
        //        method.setAccessible(true);
        //        method.invoke(BaseActivity.this, intent);
        //    }
        //}
        // 。。。。。。
    }


}
