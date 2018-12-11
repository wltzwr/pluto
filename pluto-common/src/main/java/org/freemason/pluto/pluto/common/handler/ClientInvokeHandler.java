package org.freemason.pluto.pluto.common.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.freemason.pluto.pluto.common.model.InvokeResponse;

/**
 * rpc客户端处理器
 * @author wangran
 * @since 1.0
 */
public class ClientInvokeHandler extends SimpleChannelInboundHandler<InvokeResponse> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, InvokeResponse InvokeResponse) throws Exception {
        //收到服务端响应之后要做的处理
        // TODO: 2018/7/18


        //ChannelDuplexHandler
       // Duplex



        times ++;
        //System.out.println("Client receive:" + invokeProcedure.getParameters());
    }


    public static  int times;

}