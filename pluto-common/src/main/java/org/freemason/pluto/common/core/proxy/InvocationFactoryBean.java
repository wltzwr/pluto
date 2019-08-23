package org.freemason.pluto.common.core.proxy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * rpc接口的代理工厂类
 * @author wangran0430@gmail.com
 * @since 1.0
 */
@Component
public class InvocationFactoryBean<T> implements FactoryBean<T>, InitializingBean {
    @Autowired
    private InvocationProxyFactory factory;

    //  被代理的接口
    private Class<T> referencedInterface;

    @Override
    public T getObject(){
        return factory.produce(referencedInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return referencedInterface;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void setReferencedInterface(Class<T> referencedInterface) {
        this.referencedInterface = referencedInterface;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO: 2019/8/23 初始化之后 检查
    }
}
