package org.freemason.pluto.common.endpoint;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.freemason.deepinvoker.common.handler.ChannelHandlerInitializer;

/**
 * Netty客户端端点
 * @author wangran
 * @since 1.0
 */
public class NettyClientEndpoint extends AbstractEndpoint implements ClientEndpoint{
    private final int port;
    private final String host;
    private Bootstrap bootstrap;

    public NettyClientEndpoint(int port, String host, ChannelInboundHandler...handlers){
        this.port = port;
        this.host = host;
        bootstrap = new Bootstrap();
        bootstrap.group(super.bossGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ChannelHandlerInitializer(handlers));
        start();
    }

    @Override
    protected void start(){
        try {
            channel = bootstrap.connect(host, port).sync().channel();
        } catch (InterruptedException e) {
            //ignore
        }
    }

    @Override
    public ChannelFuture send(Object msg) {
        return channel.writeAndFlush(msg);
    }

}
