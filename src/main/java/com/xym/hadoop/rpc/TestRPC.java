package com.xym.hadoop.rpc;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.net.SocketFactory;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Closeable;
import org.apache.hadoop.io.retry.RetryPolicy;
import org.apache.hadoop.ipc.Client.ConnectionId;
import org.apache.hadoop.ipc.ProtocolMetaInfoPB;
import org.apache.hadoop.ipc.ProtocolProxy;
import org.apache.hadoop.ipc.RPC.Server;
import org.apache.hadoop.ipc.RpcEngine;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.security.token.SecretManager;
import org.apache.hadoop.security.token.TokenIdentifier;
import org.junit.Before;

public class TestRPC {
  public static Configuration conf;

  @Before
  public void setupConf() {
    // new一个默认的shconfiguration
    conf = new Configuration();
    // 设置
    conf.setClass("rpc.engine." + StoppedProtocol.class.getName(), StoppedRpcEngine.class,
        RpcEngine.class);
    UserGroupInformation.setConfiguration(conf);
  }

  public static interface StoppedProtocol {
    long versionID = 0;

    public void stop();
  }

  private static class StoppedRpcEngine implements RpcEngine {

    public <T> ProtocolProxy<T> getProxy(Class<T> protocol, long clientVersion,
        InetSocketAddress addr, UserGroupInformation ticket, Configuration conf,
        SocketFactory factory, int rpcTimeout, RetryPolicy connectionRetryPolicy)
        throws IOException {

      return getProxy(protocol, clientVersion, addr, ticket, conf, factory, rpcTimeout,
          connectionRetryPolicy);
    }

    @SuppressWarnings("unused")
    public <T> ProtocolProxy<T> getProxy(Class<T> protocol, long clientVersion,
        InetSocketAddress addr, UserGroupInformation ticket, Configuration conf,
        SocketFactory factory, int rpcTimeout, RetryPolicy connectionRetryPolicy,
        AtomicBoolean fallbackToSimpleAuth) throws IOException {
      @SuppressWarnings("unchecked")
      // 通过动态代理获得一个代理对象
      T proxy =
          (T) Proxy.newProxyInstance(protocol.getClassLoader(), new Class[] {protocol},
              new StoppedInvocationHandler());
      return new ProtocolProxy<T>(protocol, proxy, false);
    }

    public Server getServer(Class<?> protocol, Object instance, String bindAddress, int port,
        int numHandlers, int numReaders, int queueSizePerHandler, boolean verbose,
        Configuration conf, SecretManager<? extends TokenIdentifier> secretManager,
        String portRangeConfig) throws IOException {

      return null;
    }

    public ProtocolProxy<ProtocolMetaInfoPB> getProtocolMetaInfoProxy(ConnectionId connId,
        Configuration conf, SocketFactory factory) throws IOException {
      // TODO Auto-generated method stub
      return null;
    }

  }
  /**
   * 这个类用来关闭动态代理
   * 
   * @author imad
   *
   */
  private static class StoppedInvocationHandler implements InvocationHandler, Closeable {
    private int closeCalled = 0;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      // TODO Auto-generated method stub
      return null;
    }

    public void close() throws IOException {
      closeCalled++;
    }

    public int getCloseCalled() {
      return closeCalled;
    }
  }
}
