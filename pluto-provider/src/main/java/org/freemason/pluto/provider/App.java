package org.freemason.pluto.provider;

import javassist.bytecode.analysis.Executor;
import org.freemason.pluto.common.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {
    static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main( String[] args ){



    }

    private static List<String> concurrentGet(){
        String original = "a|b|c|d|e|f|g";
        int threshold = 1500;
        //  ------------------------
        String[] keys = original.split("|");
        StringBuilder sb = new StringBuilder();
        List<String> params = new ArrayList<>();
        for (String key : keys) {
            if (sb.length() + key.length() < threshold){
                sb.append(key).append("/");
            } else {
                params.add(sb.deleteCharAt(sb.length() - 1).toString());
                sb.setLength(0);
            }
        }
        final CountDownLatch latch = new CountDownLatch(params.size());
        final List<String> results = new CopyOnWriteArrayList<>();
        params.forEach(e -> threadPool.execute(()->{
            results.addAll(get(e));
            latch.countDown();
            })
        );
        try {
            latch.await();
        } catch (InterruptedException e) {
            //  ignore
        }
        return results;
    }


    //ES的查询方法
    private static List<String> get(String param){
        return new ArrayList<>();
    }


}
