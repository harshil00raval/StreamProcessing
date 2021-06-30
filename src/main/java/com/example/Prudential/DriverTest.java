package com.example.Prudential;

import java.io.FileNotFoundException;
import java.util.Objects;


class MyThread extends Thread{

    MyThread(){
        System.out.println("MyThread");
    }

    public void run(){
        System.out.println("bar");
    }

    public void run(String s) throws ClassNotFoundException, ArrayIndexOutOfBoundsException, NullPointerException {
        System.out.println("baz");
    }

    public void fun(String s) throws ArrayIndexOutOfBoundsException {
        int a[] = new int[2];

        System.out.println(a[10]);
    }

    private final void test(){

    }

    private final void test(String a){

    }

}
public class DriverTest {
    public static void main(String[] args) {
        try{
            Float f = new Float("3.0");
            int x = f.intValue();
            byte b = f.byteValue();
            double d= f.doubleValue();

            System.out.println(x+b+d);
        }catch (NumberFormatException e){
            System.out.println("bad Number");
        }


//        Thread t = new MyThread(){
//            public void run(){
//                System.out.println("foo");
//            }
//        };
//
////        t.start();
//
//        MyThread mt = new MyThread();
//
//        try {
//            mt.fun("adf");
//        }
//        catch (ArrayIndexOutOfBoundsException aibe){
//            System.out.println("recovered");
//        }
//        System.out.println("blas");
    }
}

class pair{
    Integer val1;
    Integer val2;

    public pair(Integer val1, Integer val2){
        this.val1 = val1;
        this.val2 = val2;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        pair pair = (pair) o;
        return val1.equals(pair.val1) && val2.equals(pair.val2);
    }

    @Override public int hashCode() {
        return Objects.hash(val1, val2);
    }
}
