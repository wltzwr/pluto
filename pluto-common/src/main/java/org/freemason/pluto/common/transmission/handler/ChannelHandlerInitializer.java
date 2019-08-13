package org.freemason.pluto.common.transmission.handler;

import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.freemason.pluto.common.transmission.handler.codec.ProtocolDecoder;
import org.freemason.pluto.common.transmission.handler.codec.ProtocolEncoder;

/**
 * Netty处理器初始化器
 * @author wangran
 * @since 1.0
 */
public class ChannelHandlerInitializer extends ChannelInitializer<SocketChannel> {

    private ChannelInboundHandler[] handlers;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new ProtocolDecoder());
        pipeline.addLast(new ProtocolEncoder());
        pipeline.addLast(handlers);
    }

    public ChannelHandlerInitializer(ChannelInboundHandler...handlers){
        this.handlers = handlers;
    }
}
