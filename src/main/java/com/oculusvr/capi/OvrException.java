/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oculusvr.capi;

/**
 *
 * @author cramirez
 */
public class OvrException extends Exception {

  private int result;
  private String errorInfo;

  public static OvrException createException() {
    
    ErrorInfo lastErrorInfo = Hmd.getLastErrorInfo();

    return new OvrException(lastErrorInfo.getErrorString() + " (" + lastErrorInfo.Result + ")");
    
  }

  public static OvrException createException(String message) {
    
    ErrorInfo lastErrorInfo = Hmd.getLastErrorInfo();

    return new OvrException(message + ": " + lastErrorInfo.getErrorString() + " (" + lastErrorInfo.Result + ")");
    
  }
  
  public OvrException() {
    super();

    init();
  }    

  public OvrException(String message) {
    super(message);

    init();
  }

  public OvrException(String message, Throwable cause) {
    super(message, cause);

    init();
  }

  public OvrException(Throwable cause) {
    super(cause);

    init();
  }

  private void init() {
    ErrorInfo lastErrorInfo = Hmd.getLastErrorInfo();

    result = lastErrorInfo.Result;
    errorInfo = lastErrorInfo.getErrorString();
  }
  
  public int getResult() {
    return result;
  }

  public String getErrorInfo() {
    return errorInfo;
  }
  
  
}
