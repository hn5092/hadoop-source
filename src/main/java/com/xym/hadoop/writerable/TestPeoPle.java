package com.xym.hadoop.writerable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableFactories;
import org.apache.hadoop.io.WritableFactory;

public class TestPeoPle implements Writable{
  static{
    WritableFactories.setFactory(TestPeoPle.class, new WritableFactory() {
      
      public Writable newInstance() {
        return new TestPeoPle();
      }
    });
  }
  public void write(DataOutput out) throws IOException {
    // TODO Auto-generated method stub
    
  }

  public void readFields(DataInput in) throws IOException {
    // TODO Auto-generated method stub
    
  }
  public void sayhi (){
    System.out.println("hello world");
  }

}
