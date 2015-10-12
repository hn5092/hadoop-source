package com.xym.hadoop.yarn.yarnapp;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.yarn.client.api.async.AMRMClientAsync.CallbackHandler;
import org.apache.hadoop.yarn.conf.YarnConfiguration;

public class MyApplicationMaster {
	public static void main(String[] args) {
		System.out.println("coming");
//		YarnConfiguration yarnConf = new YarnConfiguration(new Configuration());
//		CallbackHandler callbackHandler = new MyCallbackHandle();
//		InetSocketAddress socketAddr = yarnConf.getSocketAddr(YarnConfiguration.RM_ADDRESS,
//				YarnConfiguration.DEFAULT_RM_ADDRESS,
//				YarnConfiguration.DEFAULT_RM_PORT);
//		System.out.println(socketAddr.getHostName()+"|"+socketAddr.getHostString()+"|" +
//				socketAddr.getPort() + "|" + socketAddr.getAddress());
////		yarnConf.setSocketAddr("", new InetSocketAddress("192.168.80.103",8032));
		
	}
}
