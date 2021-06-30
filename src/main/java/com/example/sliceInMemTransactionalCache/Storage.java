package com.example.sliceInMemTransactionalCache;

import lombok.SneakyThrows;

import java.util.*;
import java.util.concurrent.*;

public class Storage {

    public final Map<String, String> cache = new ConcurrentHashMap<>();
    private static final Storage stg = new Storage();
    BlockingQueue<Operation> operationQueue = new LinkedBlockingDeque<>();

    private Storage(){
        Executor ex = new Executor();
        Thread th = new Thread(ex);
        th.start();
    }
    public static Storage createStorage(){
        return stg;
    }

    public static Storage getStorage(){
        return stg;
    }

    public String get(String key){
        return cache.get(key);
    }

    public void set(String key, String value){
        cache.put(key, value);
    }

    public void remove(String key){
        cache.remove(key);
    }

    public int count(String value){
        return 0;
    }

    @SneakyThrows public synchronized void commit(List<Operation> ops){
        for (Operation op : ops) {
            operationQueue.put(op);
        }
    }

    //only write ops will come here   either set or delete
    class Executor implements Runnable{

        @SneakyThrows @Override public void run() {
            while(true){
                Operation op = operationQueue.take();
                if("set".equals(op.getOperation())){
                    stg.set(op.getKey(), op.getValue());
                }else if("remove".equals(op.getOperation())){
                    stg.remove(op.getKey());
                }
            }
        }
    }
}
