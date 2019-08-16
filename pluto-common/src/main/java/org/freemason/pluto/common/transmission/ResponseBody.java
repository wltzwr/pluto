package org.freemason.pluto.common.transmission;

import java.io.Serializable;

public class ResponseBody implements Serializable {
    private final Object result;

    private boolean success;

    private String exceptionMessage;

    public static  ResponseBody newSuccessBody(Object result){
        return new ResponseBody(result, true);
    }

    public static  ResponseBody newFailureBody(Exception exception){
        return new ResponseBody(exception);
    }

    public ResponseBody(Object result, boolean success, String exceptionMessage) {
        this.result = result;
        this.success = success;
        this.exceptionMessage = exceptionMessage;
    }

    public ResponseBody(Object result, boolean success) {
        this(result, success, null);
    }

    public ResponseBody(Exception e) {
        this(null, false, e.getMessage());
    }

    public Object getResult() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

}
