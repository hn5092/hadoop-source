package com.xym.hadoop.rpc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObj extends UnicastRemoteObject implements RMIQuery{

  protected RemoteObj() throws RemoteException {
    super();
  }

  public void sayhi() throws RemoteException {
    System.out.println("这是远程对象");
  }

}
