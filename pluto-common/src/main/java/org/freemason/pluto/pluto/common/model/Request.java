package org.freemason.pluto.pluto.common.model;

public interface Request<T> {
    String getId();

    byte getType();

    Object[] getParameters();

    T getPayload();
    //MethodMetaData getInvocationMetaData();
}
