package org.freemason.pluto.common.core;
/**
 * 异常类
 * @author wangran0430@gmail.com
 * @since 1.0
 */
public class InvocationException extends RuntimeException{
    public InvocationException(Exception e){
        super(e);
    }
    public InvocationException(String message){
        super(message);
    }
}
