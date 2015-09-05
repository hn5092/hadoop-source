package com.xym.hadoop.proxy;

import java.lang.reflect.Proxy;

public class Test {
  public static void main(String[] args) {
    //A是被代理对象 INVOKER是代理他的
    Invoker invoker = new Invoker(new A());
    Master master = (Master)Proxy.newProxyInstance(Master.class.getClassLoader(), new Class[] {Master.class},invoker);
    master.show();
   int[] a =new int[] {1,2,3};
   
  }
}
