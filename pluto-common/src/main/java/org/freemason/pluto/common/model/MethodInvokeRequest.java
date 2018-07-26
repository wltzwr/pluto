package org.freemason.pluto.common.model;

import org.springframework.util.Assert;

import java.lang.reflect.Method;

import static org.freemason.pluto.common.Constants.DEFAULT_VERSION;

public class MethodInvokeRequest implements InvokeRequest{
    private final String id;

    private String version;

    private String className;

    private String methodName;

    private String[] parameterTypeNames;

    private Object[] parameters;


    public MethodInvokeRequest(String version, String id, Method method, Object...parameters) {
        Assert.notNull(method, "method must not be null.");
        if (method.getParameterCount() > 0 && parameters != null){
            Assert.isTrue(method.getParameterCount() == parameters.length, "wrong number of arguments.");
        }
        this.version = version;
        this.id = id;
        this.methodName = method.getName();
        this.className = method.getDeclaringClass().getName();
        this.parameters = parameters;
        setParameterTypeNames(method.getParameterTypes());
    }

    public MethodInvokeRequest(String id, Method method, Object...parameters) {
        this(DEFAULT_VERSION, id, method, parameters);
    }

    public MethodInvokeRequest(String id, Method method) {
        this(DEFAULT_VERSION, id, method, null);
    }



    @Override
    public String version() {
        return version;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public String getMethodName() {
        return methodName;
    }

    @Override
    public Object[] getParameters() {
        return parameters;
    }

    @Override
    public String[] getParameterTypeNames() {
        return parameterTypeNames;
    }


    private void setParameterTypeNames(Class<?>[] parameterTypes) {
        int length = parameterTypes.length;
        this.parameterTypeNames = new String[length];
        for (int i = 0; i < length; i++) {
            parameterTypeNames[i] = parameterTypes[i].getName();
        }
    }
}
