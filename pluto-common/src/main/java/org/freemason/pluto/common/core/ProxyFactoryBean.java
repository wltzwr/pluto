package org.freemason.pluto.common.core;

import org.springframework.beans.factory.FactoryBean;
import java.lang.reflect.Proxy;
/**
 * rpc接口的代理工厂bean
 * @author wangran0430@gmail.com
 * @since 1.0
 */
public class ProxyFactoryBean<T> implements FactoryBean<T> {

    private Class<T> referencedInterface;

    @Override
    public T getObject(){
        return (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader()
                , new Class[]{referencedInterface}
                , new ReferenceInvocationHandler());
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
