package com.xym.hadoop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Invoker implements InvocationHandler{
  Master master;
  public Invoker(Master master) {
    this.master = master;
  }
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    
    method.invoke(master,args);
    return null;
  }

}   
