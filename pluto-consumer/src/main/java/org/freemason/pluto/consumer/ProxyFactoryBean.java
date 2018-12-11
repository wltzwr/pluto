package org.freemason.pluto.consumer;

import org.springframework.beans.factory.FactoryBean;

public class ProxyFactoryBean<T> implements FactoryBean<T>{

    private Class<T> referencedInterface;

    @Override
    public T getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return referencedInterface == null ? null : referencedInterface.getClass();
    }
}
