package org.freemason.pluto.common.transmission.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.freemason.pluto.common.transmission.InvocationResponse;
import org.freemason.pluto.common.transmission.Message;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * rpc客户端处理器
 * @author wangran
 * @since 1.0
 */
public class ClientInvocationHandler extends SimpleChannelInboundHandler<InvocationResponse> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, InvocationResponse response) throws Exception {
        //收到服务端响应之后要做的处理

    }

    private Map<String, Thread> waitThread;

    private Map<String, Message> cache;

    public ClientInvocationHandler(Map<String, Thread> waitThread, Map<String, Message> cache){
        this.waitThread = waitThread;
        this.cache = cache;
    }
}
