package org.freemason.pluto.common.transmission.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.freemason.pluto.common.transmission.InvocationResponse;

/**
 * rpc客户端处理器
 * @author wangran
 * @since 1.0
 */
public class ClientInvokeHandler extends SimpleChannelInboundHandler<InvocationResponse> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, InvocationResponse response) throws Exception {
        //收到服务端响应之后要做的处理
        // TODO: 2018/7/18


        //ChannelDuplexHandler
       // Duplex



        times ++;
        //System.out.println("Client receive:" + invokeProcedure.getParameters());
    }


    public static  int times;

}
