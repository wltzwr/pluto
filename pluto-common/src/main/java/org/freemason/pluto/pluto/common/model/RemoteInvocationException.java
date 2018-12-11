package org.freemason.pluto.pluto.common.model;

public class RemoteInvocationException extends RuntimeException{
    public RemoteInvocationException(Exception e){
        super(e);
    }

    public RemoteInvocationException(String message){
        super(message);
    }
}
