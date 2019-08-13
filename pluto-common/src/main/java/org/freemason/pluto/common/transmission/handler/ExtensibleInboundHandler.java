package org.freemason.pluto.common.transmission.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtensibleInboundHandler implements ChannelInboundHandler{

    private Set<ChannelInboundHandler> bizHandlers = new HashSet<>();

    public ExtensibleInboundHandler(ChannelInboundHandler...inboundHandlers){
        bizHandlers.addAll(Arrays.asList(inboundHandlers));
    }

    public void addHandler(ChannelInboundHandler handler){
        if (handler != null){
            bizHandlers.add(handler);
        }
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        for (ChannelInboundHandler bizHandler : bizHandlers) {
            bizHandler.channelRegistered(ctx);
        }
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        for (ChannelInboundHandler bizHandler : bizHandlers) {
            bizHandler.channelUnregistered(ctx);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (ChannelInboundHandler bizHandler : bizHandlers) {
            bizHandler.channelActive(ctx);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        for (ChannelInboundHandler bizHandler : bizHandlers) {
            bizHandler.channelInactive(ctx);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        for (ChannelInboundHandler bizHandler : bizHandlers) {
            bizHandler.channelRead(ctx, msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        for (ChannelInboundHandler bizHandler : bizHandlers) {
            bizHandler.channelReadComplete(ctx);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        for (ChannelInboundHandler bizHandler : bizHandlers) {
            bizHandler.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        for (ChannelInboundHandler bizHandler : bizHandlers) {
            bizHandler.channelWritabilityChanged(ctx);
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        for (ChannelInboundHandler bizHandler : bizHandlers) {
            bizHandler.handlerAdded(ctx);
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        for (ChannelInboundHandler bizHandler : bizHandlers) {
            bizHandler.handlerRemoved(ctx);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        for (ChannelInboundHandler bizHandler : bizHandlers) {
            bizHandler.exceptionCaught(ctx, cause);
        }
    }
}
