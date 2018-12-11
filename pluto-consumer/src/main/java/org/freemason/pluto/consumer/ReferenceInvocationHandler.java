package org.freemason.pluto.consumer;

import org.freemason.pluto.pluto.common.endpoint.ClientEndpoint;
import org.freemason.pluto.pluto.common.endpoint.NettyClientEndpoint;
import org.freemason.pluto.pluto.common.handler.ClientInvokeHandler;
import org.freemason.pluto.pluto.common.model.InvokeRequest;
import org.freemason.pluto.pluto.common.model.MethodInvokeRequest;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ReferenceInvocationHandler implements InvocationHandler, Serializable{
    ClientEndpoint client = new NettyClientEndpoint(8341, "localhost", new ClientInvokeHandler());
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        InvokeRequest request = new MethodInvokeRequest(method, args);

        return client.send(request);
    }

}
