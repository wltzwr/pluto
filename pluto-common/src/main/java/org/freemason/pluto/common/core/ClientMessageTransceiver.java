package org.freemason.pluto.common.core;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.freemason.pluto.common.transmission.InvocationResponse;
import org.freemason.pluto.common.transmission.Message;
import org.freemason.pluto.common.transmission.RequestBody;
import org.freemason.pluto.common.transmission.endpoint.NettyClientEndpoint;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

@Component
public class ClientMessageTransceiver extends SimpleChannelInboundHandler<InvocationResponse> {


    private final Map<String, Thread> waitThreads = new ConcurrentHashMap<>();
    private final Map<String, Message> resultCache = new ConcurrentHashMap<>();


    private NettyClientEndpoint clientEndpoint = new NettyClientEndpoint("localhost", 43092, this);

    public InvocationResponse exchange(Message<RequestBody, String> message) throws Exception{
        clientEndpoint.send(message);
        waitThreads.put(message.getId(), Thread.currentThread());
        LockSupport.park();
        return (InvocationResponse)resultCache.get(message.getId());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, InvocationResponse response) throws Exception {
        String messageId = response.getId();
        resultCache.put(messageId, response);
        LockSupport.unpark(waitThreads.get(messageId));
    }
}
