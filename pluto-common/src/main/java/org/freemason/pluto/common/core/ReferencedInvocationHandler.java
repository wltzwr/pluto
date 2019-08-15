package org.freemason.pluto.common.core;

import io.netty.channel.ChannelFuture;
import org.freemason.pluto.common.transmission.InvocationRequest;
import org.freemason.pluto.common.transmission.Message;
import org.freemason.pluto.common.transmission.RequestBody;
import org.freemason.pluto.common.transmission.ResponseBody;
import org.freemason.pluto.common.transmission.endpoint.ClientEndpoint;
import org.freemason.pluto.common.transmission.endpoint.NettyClientEndpoint;
import org.freemason.pluto.common.transmission.handler.ClientInvokeHandler;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * rpc接口动态代理类的InvocationHandler
 * 将方法调用封装为rpc调用请求{@link InvocationRequest} 并执行
 * @author wangran0430@gmail.com
 * @since 1.0
 */
public class ReferencedInvocationHandler implements InvocationHandler, Serializable{
  // ClientEndpoint client=  new NettyClientEndpoint(8341, "localhost", new ClientInvokeHandler());
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*InvocationRequest request = new InvocationRequest(method, args);
        try {
            Message<ResponseBody, String> response = MessageTransceiver.exchange(request);
            ResponseBody responseBody =
            if (response.getBody().isSuccess()){
                return
            }
            return new Object();
        }*/
        return null;
    }


    public static void main(String[] args) throws Throwable {
        ReferencedInvocationHandler r = new ReferencedInvocationHandler();
        r.invoke(new Object(),Object.class.getMethod("hashCode"),null);



    }
}
