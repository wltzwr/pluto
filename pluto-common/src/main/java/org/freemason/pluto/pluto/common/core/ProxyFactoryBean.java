package org.freemason.pluto.pluto.common.core;

import org.springframework.beans.factory.FactoryBean;
import java.lang.reflect.Proxy;

public class ProxyFactoryBean<T> implements FactoryBean<T> {

    private Class<T> referencedInterface;

    @Override
    public T getObject(){
        return (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{referencedInterface}, new ReferenceInvocationHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return referencedInterface;
    }

    public void setReferencedInterface(Class<T> referencedInterface) {
        this.referencedInterface = referencedInterface;
    }

    public ProxyFactoryBean(){
        this(null);
    }
    public ProxyFactoryBean(Class<T> referencedInterface){
        this.referencedInterface = referencedInterface;
    }
}
