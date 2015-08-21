package com.xym.hadoop.rpc;

import java.lang.reflect.Proxy;

public class Test {
  public static void main(String[] args) {
    Invoker invoker = new Invoker(new A());
    Master master = (Master)Proxy.newProxyInstance(Master.class.getClassLoader(), new Class[] {Master.class},invoker);
    master.show();
   int[] a =new int[] {1,2,3};
   
  }
}
