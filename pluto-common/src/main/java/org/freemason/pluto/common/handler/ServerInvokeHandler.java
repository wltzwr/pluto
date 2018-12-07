package org.freemason.pluto.common.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.freemason.deepinvoker.common.core.InvocationHandler;
import org.freemason.deepinvoker.common.model.InvokeProcedure;
import org.springframework.util.Assert;

/**
 * rpc服务端处理器
 * @author wangran
 * @since 1.0
 */
@ChannelHandler.Sharable
public class ServerInvokeHandler extends SimpleChannelInboundHandler<InvokeProcedure> {

    private InvocationHandler invocationHandler;

    public ServerInvokeHandler(InvocationHandler invocationHandler) {
        Assert.notNull(invocationHandler, "invocationHandler must not be null");
        this.invocationHandler = invocationHandler;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, InvokeProcedure invokeProcedure) throws Exception {
        //System.out.println("server receive:" + invokeProcedure.getParameters());

        //服务端处理调用请求的核心类
        InvokeProcedure result = invocationHandler.invoke(invokeProcedure);
        //服务端响应一个消息
        channelHandlerContext.writeAndFlush(result);
    }

    /*@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接的客户端地址:" + ctx.channel().remoteAddress());
        //super.channelActive(ctx);
    }*/
}
