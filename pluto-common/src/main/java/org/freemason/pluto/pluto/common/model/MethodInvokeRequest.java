package org.freemason.pluto.pluto.common.model;

import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.UUID;


public class MethodInvokeRequest implements InvokeRequest{
    private final String id;

    private String className;

    private String methodName;

    private String[] parameterTypeNames;

    private Object[] parameters;

    public MethodInvokeRequest(String id, Method method, Object...parameters) {
        Assert.notNull(id, "id must not be null.");
        Assert.notNull(method, "method must not be null.");
        this.id = id;
        this.methodName = method.getName();
        this.className = method.getDeclaringClass().getName();
        initParameters(method, parameters);
    }

    public MethodInvokeRequest(Method method, Object...parameters) {
        this(UUID.randomUUID().toString(), method, parameters);
    }

    public MethodInvokeRequest(Method method) {
        this(method, null);
    }

    private void initParameters(Method method, Object...parameters) {
        int requiredParamCount = method.getParameterCount();
        if (requiredParamCount == 0){
            this.parameters = null;
            this.parameterTypeNames = null;
            return;
        }
        int suppliedParamCount = parameters == null ? 0 : parameters.length;
        Assert.isTrue(requiredParamCount == suppliedParamCount, "suppliedParamCount must be equal to requiredParamCount");
        this.parameters = parameters;
        this.parameterTypeNames = new String[requiredParamCount];
        Class<?>[] paramTypes = method.getParameterTypes();
        for (int i = 0; i < requiredParamCount; i++) {
            parameterTypeNames[i] = paramTypes[i].getName();
        }
    }

    @Override
    public final String getId() {
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


    /*private void initParameterTypeNames(Class<?>[] parameterTypes) {
        int length = parameterTypes.length;
        this.parameterTypeNames = new String[length];
        for (int i = 0; i < length; i++) {
            parameterTypeNames[i] = parameterTypes[i].getName();
        }
    }*/
}
