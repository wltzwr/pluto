package org.freemason.pluto.common.transmission.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.freemason.pluto.common.model.InvokeRequest;
import org.freemason.pluto.common.model.InvokeResponse;
import org.freemason.pluto.common.model.SuccessResponse;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;

/**
 * rpc服务端处理器
 * @author wangran
 * @since 1.0
 */
@ChannelHandler.Sharable
public class ServerInvokeHandler extends SimpleChannelInboundHandler<InvokeRequest> implements ApplicationContextAware{
    private ApplicationContext applicationContext;


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, InvokeRequest invokeRequest) throws Exception {
        Class<?> clazz = Class.forName(invokeRequest.getClassName());
        Object bean = applicationContext.getBean(clazz);
        Method method = clazz.getMethod(invokeRequest.getMethodName(), resolveParamTypes(invokeRequest.getParameterTypeNames()));
        Object result = method.invoke(bean, invokeRequest.getParameters());
        InvokeResponse response = new SuccessResponse(invokeRequest,"success");

        //服务端响应一个消息
        channelHandlerContext.writeAndFlush(response);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /*@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接的客户端地址:" + ctx.channel().remoteAddress());
        //super.channelActive(ctx);
    }*/

    private Class<?>[] resolveParamTypes(String...typeNames) throws ClassNotFoundException {
        if (typeNames == null || typeNames.length == 0){
            return null;
        }
        Class<?>[] classes = new Class<?>[typeNames.length];
        for (int i = 0; i < classes.length; i++){
            classes[i] = Class.forName(typeNames[i]);
        }
        return classes;
    }

}
