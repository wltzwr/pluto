package org.freemason.pluto.pluto.common.method;

import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodMetaData {

    private transient Method method;

    private List<String> parameterTypeNames;

    private String returnTypeName;

    public MethodMetaData(Method method){
        Assert.notNull(method, "method must not be null");
        this.method = method;
        init();
    }

    public String getMethodName(){
        return method.getName();
    }

    public List<String> getParameterTypeNames(){
        return parameterTypeNames;
    }

    public String getReturnType() {
        return returnTypeName;
    }

    private void init(){
        initParameterTypeNames();
        initReturnedTypeName();
    }

    private void initReturnedTypeName() {
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


        return false;
    }
}
