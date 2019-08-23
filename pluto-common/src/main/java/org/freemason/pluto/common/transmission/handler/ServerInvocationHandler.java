package org.freemason.pluto.common.transmission.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.freemason.pluto.common.core.HandlerMetaData;
import org.freemason.pluto.common.core.proxy.InvocationMappingHandlerMapping;
import org.freemason.pluto.common.transmission.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * rpc服务端处理器
 * @author wangran
 * @since 1.0
 */
@ChannelHandler.Sharable
@Component
public class ServerInvocationHandler extends SimpleChannelInboundHandler<InvocationRequest>{
    @Autowired
    private InvocationMappingHandlerMapping invocationHandlerMapping;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, InvocationRequest request) throws Exception {
        RequestBody body = request.getBody();
        HandlerMetaData metaData = invocationHandlerMapping.getHandlerMethod(body);
        Message<ResponseBody, String> response;
        if (metaData == null){
            response = new InvocationResponse(request, ResponseBody.newFailureBody(new NoSuchMethodException()));
        } else {
            Object[] args = body.getArgs();
            Object result;
            if (args != null && args.length > 0) {
                result = metaData.getHandlerMethod().invoke(metaData.getHandlerObject(), args);
            } else {
                result = metaData.getHandlerMethod().invoke(metaData.getHandlerObject());
            }
            response = new InvocationResponse(request, ResponseBody.newSuccessBody(result));
        }
        //服务端响应一个消息
        channelHandlerContext.writeAndFlush(response);
    }
    /*@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接的客户端地址:" + ctx.channel().remoteAddress());
        //super.channelActive(ctx);
    }*/
}
