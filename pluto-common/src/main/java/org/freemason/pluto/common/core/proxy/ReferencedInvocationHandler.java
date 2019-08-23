package org.freemason.pluto.common.core.proxy;

import org.freemason.pluto.common.core.ClientMessageTransceiver;
import org.freemason.pluto.common.core.InvocationException;
import org.freemason.pluto.common.transmission.InvocationRequest;
import org.freemason.pluto.common.transmission.InvocationResponse;
import org.freemason.pluto.common.transmission.Message;
import org.freemason.pluto.common.transmission.ResponseBody;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * rpc接口动态代理类的InvocationHandler
 * 将方法调用封装为rpc调用请求{@link InvocationRequest} 并执行
 * @author wangran0430@gmail.com
 * @since 1.0
 */
public class ReferencedInvocationHandler implements InvocationHandler{

    private ClientMessageTransceiver transceiver;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        InvocationRequest request = new InvocationRequest(method, args);
        try {
            InvocationResponse response = transceiver.exchange(request);
            ResponseBody responseBody = response.getBody();
            if (responseBody.isSuccess()){
                return responseBody.getResult();
            } else {
                throw new InvocationException(responseBody.getExceptionMessage());
            }
        } catch (Exception e){
            throw new InvocationException(e);
        }
    }


    public ReferencedInvocationHandler(ClientMessageTransceiver transceiver){
        this.transceiver = transceiver;
    }
}
