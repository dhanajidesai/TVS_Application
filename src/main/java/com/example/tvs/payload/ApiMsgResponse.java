package com.example.tvs.payload;

import java.io.Serializable;
import java.util.List;




public class ApiMsgResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private int status;
  private String message;
  public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public List<String> getErrors() {
	return errors;
}

public void setErrors(List<String> errors) {
	this.errors = errors;
}

public Object getResponseObject() {
	return responseObject;
}

public void setResponseObject(Object responseObject) {
	this.responseObject = responseObject;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

private List<String> errors;
  private Object responseObject;

  public ApiMsgResponse(int status, String message, List<String> errors, Object responseObject) {
    this.status = status;
    this.message = message;
    this.errors = errors;
    this.responseObject = responseObject;
  }

  public ApiMsgResponse(int status, String message, Object responseObject) {
    this.status = status;
    this.message = message;
    this.responseObject = responseObject;
  }

  public ApiMsgResponse(int status_code, String message, List<String> errors) {
    this.status = status_code;
    this.message = message;
    this.errors = errors;
  }

  public ApiMsgResponse() {}

  // @Override
  // public String toString() {
  // return "ApiMsgResponse [statusCode=" + status + ", message=" + errors != null ? errors.toString()
  // : "-" + "]";
  // }
}
