package org.freemason.pluto.common.transmission;

import java.io.Serializable;

public class ResponseBody implements Serializable {
    private final Object result;

    private boolean success;

    private String exceptionMessage;

    public static  ResponseBody newSuccessBody(Object result){
        return new ResponseBody(result);
    }

    public static  ResponseBody newFailureBody(String exceptionMessage){
        return new ResponseBody(exceptionMessage);
    }

    public ResponseBody(Object result, boolean success, String exceptionMessage) {
        this.result = result;
        this.success = success;
        this.exceptionMessage = exceptionMessage;
    }

    public ResponseBody(Object result, boolean success) {
        this(result, success, null);
    }

    public ResponseBody(Object result) {
        this(result, true, null);
    }

    public ResponseBody(String exceptionMessage) {
        this(null, false, exceptionMessage);
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
