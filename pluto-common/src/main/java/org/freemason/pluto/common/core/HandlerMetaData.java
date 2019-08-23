package org.freemason.pluto.common.core;

import java.lang.reflect.Method;

public class HandlerMetaData {
    private final Object handlerObject;
    private final Method handlerMethod;
    public HandlerMetaData(Object handlerObject, Method handlerMethod) {
        this.handlerObject = handlerObject;
        this.handlerMethod = handlerMethod;
    }

    public Method getHandlerMethod() {
        return handlerMethod;
    }

    public Object getHandlerObject() {
        return handlerObject;
    }
}
