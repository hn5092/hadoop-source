package com.xym.hadoop.nio.channel;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class SocketChanelDemo {
  public static void main(String[] args) throws IOException {
    SocketChannel channel = SocketChannel.open();
    channel.configureBlocking(false); //设置成为为非阻塞模式
    Object lockobj = channel.blockingLock();
    //上锁 
    synchronized (lockobj) {
    boolean blocking = channel.isBlocking(); 
    channel.configureBlocking(false);
     
     
     
    }
  }
}
