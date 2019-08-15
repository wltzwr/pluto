package org.freemason.pluto.common.transmission;

import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RequestBody  implements Serializable {
    private transient Method method;

    private String className;

    private String methodName;

    private List<String> parameterTypeNames;

    private String returnTypeName;

    private Object[] args;

    public RequestBody(Method method, Object[] args){
        Assert.notNull(method, "method must not be null");
        this.method = method;
        this.args = args;
        init();
    }

    public RequestBody(Method method){
        this(method, null);
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

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    private void init(){
        initParameterTypeNames();
        this.methodName = method.getName();
        this.className = method.getDeclaringClass().getSimpleName();
        this.returnTypeName = method.getReturnType().getSimpleName();
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
        if (!(obj instanceof RequestBody))
            return false;
        RequestBody other = (RequestBody)obj;
        if (this == other)
            return true;
        //  方法重载要求方法名和返回值类型相同 只有参数不同
        return this.getMethodName().equals(other.getMethodName())
                && this.getParameterTypeNames().equals(other.getParameterTypeNames())
                && this.getReturnType().equals(other.getReturnType())
                && this.getClassName().equals(other.getClassName());
    }

    @Override
    public int hashCode() {
        return this.getReturnType().hashCode()
                + this.getParameterTypeNames().hashCode()
                + this.getMethodName().hashCode()
                + this.getClassName().hashCode();
    }

}
