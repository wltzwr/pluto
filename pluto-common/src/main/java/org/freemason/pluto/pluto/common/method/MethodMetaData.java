package org.freemason.pluto.pluto.common.method;

import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodMetaData {

    private transient Method method;

    private String className;

    private String methodName;

    private List<String> parameterTypeNames;

    private String returnTypeName;

    public MethodMetaData(Method method){
        Assert.notNull(method, "method must not be null");
        this.method = method;
        init();
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName(){
        return methodName;
    }

    public List<String> getParameterTypeNames(){
        return parameterTypeNames;
    }

    public String getReturnType() {
        return returnTypeName;
    }



    private void init(){
        initParameterTypeNames();
        this.className = method.getDeclaringClass().getName();
        this.methodName = method.getName();
        returnTypeName = method.getReturnType().getSimpleName();
    }

    private void initParameterTypeNames(){
        Class<?>[] classes = method.getParameterTypes();
        if (classes.length > 0){
            parameterTypeNames = new ArrayList<>(classes.length);
            for (Class<?> clazz : classes){
                parameterTypeNames.add(clazz.getSimpleName());
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof MethodMetaData))
            return false;
        MethodMetaData other = (MethodMetaData)obj;
        if (this == other)
            return true;
        return this.getMethodName().equals(other.getMethodName())
                && this.getParameterTypeNames().equals(other.parameterTypeNames)
                && this.getReturnType().equals(other.getReturnType());
    }

    @Override
    public int hashCode() {
        return this.getReturnType().hashCode() + this.getParameterTypeNames().hashCode() + this.getMethodName().hashCode();
    }
}
