package org.freemason.pluto.common.core.proxy;

import org.freemason.pluto.common.core.ClientMessageTransceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class InvocationProxyFactory {
    @Autowired
    private ClientMessageTransceiver transceiver;

    @SuppressWarnings("unchecked")
    public <T> T produce(Class<T> type){
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader()
                , new Class[]{type}
                , new ReferencedInvocationHandler(transceiver));
    }

}
