package com.xym.hadoop.thread.more;

import org.glassfish.grizzly.impl.UnsafeFutureImpl;

import sun.misc.Unsafe;

public class 手动阻塞线程 {
    private static final Unsafe unsafe = Unsafe.getUnsafe();

	
	
	static class A extends Thread{
		@Override
		public void run() {
			System.out.println("开始阻塞");
			unsafe.park(arg0, arg1);
		}
	}
	static class A extends Thread{
		@Override
		public void run() {
			
		}
	}
}
