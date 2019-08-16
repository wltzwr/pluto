package org.freemason.pluto.common.core;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/**
 * rpc接口的代理工厂类
 * @author wangran0430@gmail.com
 * @since 1.0
 */
public class ProxyFactoryBean<T> implements FactoryBean<T> {
    //  被代理的接口
    private Class<T> referencedInterface;

    private InvocationHandler handler;

    public void setHandler(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    @SuppressWarnings("unchecked")//  动态代理类实现了referencedInterface 强制类型转换不出产生ClassCastException,避免编译器警告
    public T getObject(){
        return (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader()
                , new Class[]{referencedInterface}
                , handler);
    }

    @Override
    public Class<?> getObjectType() {
        return referencedInterface;
    }

    public ProxyFactoryBean(Class<T> referencedInterface){
        this.referencedInterface = referencedInterface;
    }
}
