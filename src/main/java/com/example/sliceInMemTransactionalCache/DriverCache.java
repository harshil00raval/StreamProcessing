package com.example.sliceInMemTransactionalCache;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class DriverCache {

    @SneakyThrows public static void main(String[] args) {
        Storage.createStorage();

        ExecutorService es = Executors.newFixedThreadPool(5);


        Operation op1 = new Operation("set", "ab", "bc");
        Operation op2 = new Operation("set","bc", "cd");
        Operation op3 = new Operation("get", "ab", "");
        Operation op4 = new Operation("get", "xc", "");
        Operation op5 = new Operation("remove", "ab", "");
        Operation op6 = new Operation("set", "hi", "ih");
        Operation op7 = new Operation("set", "hi", "ji");
        Operation op8 = new Operation("set" , "hi", "12");
        Operation op9 = new Operation("set" , "hi", "23");
        Operation op10 = new Operation("set" , "hi", "34");
        Operation op11 = new Operation("set" , "hi", "45");
        Operation op12 = new Operation("set" , "hi", "56");
        Operation commit = new Operation("commit", "", "");
        Operation rollback = new Operation("rollback", "", "");

        Transaction t1 = new Transaction();
        t1.addOperation(op1);
        t1.addOperation(op3);
        t1.addOperation(op7);
        t1.addOperation(op9);
        t1.addOperation(commit);

        Transaction t2 = new Transaction();
        t2.addOperation(op2);
        t2.addOperation(op5);
        t2.addOperation(op11);
        t2.addOperation(op12);

        Transaction t3 = new Transaction();
        t3.addOperation(op4);
        t3.addOperation(op6);
        t3.addOperation(op8);
        t3.addOperation(op10);

        Transaction t4 = new Transaction();
        t4.addOperation(op1);
        t4.addOperation(op6);
        t4.addOperation(op9);
        t4.addOperation(op12);

        Transaction t5 = new Transaction();
        t5.addOperation(op1);
        t5.addOperation(op3);
        t5.addOperation(op7);
        t5.addOperation(op9);

        Request rs1 = new Request(t1);
        Request rs2 = new Request(t2);
        Request rs3 = new Request(t3);
        Request rs4 = new Request(t4);
        Request rs5 = new Request(t5);

        es.execute(rs1);
        es.execute(rs2);
        es.execute(rs3);
        es.execute(rs4);
        es.execute(rs5);


        Thread.sleep(2000);

        Storage sg = Storage.getStorage();

        for(String str : sg.cache.keySet()){
            System.out.println(str);
        }


    }
}
