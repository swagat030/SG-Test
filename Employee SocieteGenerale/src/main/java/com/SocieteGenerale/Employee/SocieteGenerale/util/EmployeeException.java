package com.SocieteGenerale.Employee.SocieteGenerale.util;

import java.io.Serializable;

public class EmployeeException extends Exception implements Serializable
{
    private static final long serialVersionUID = 1L;
    public String errorCode = "";
    
    public EmployeeException() {
        super();
    }
    
    public EmployeeException(Exception e)
	{
		super (e);
	}
    
    public EmployeeException(String msg)   {
        super(msg);
    }
    
    public EmployeeException(String msg, Exception e)  {
        super(msg, e);
    }
    
    public EmployeeException(String msg, Exception e, String errCode) {
    	super(msg, e);
    	this.errorCode = errCode;
    }
    
    public String getErrorCode() {
    	return this.errorCode;
    }
    
    public void setErrorCode(String errCode) {
    	this.errorCode = errCode;
    }
    
}