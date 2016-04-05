package com.oculusvr.capi;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorInfo extends Structure implements Structure.ByValue {
  public int Result;
  public byte[] ErrorString = new byte[512];

  public ErrorInfo() {
    super();
  }

  public ErrorInfo(Pointer peer) {
    super(peer);
  }

  @Override
  protected List<?> getFieldOrder() {
    return Arrays.asList("Result", "ErrorString");
  }
  
  public String getErrorString() {
    try {
      return new String(ErrorString, "UTF-8");
    } catch (UnsupportedEncodingException ex) {
      Logger.getLogger(HmdDesc.class.getName()).log(Level.SEVERE, null, ex);
      
      return null;
    }
  }
  
}
