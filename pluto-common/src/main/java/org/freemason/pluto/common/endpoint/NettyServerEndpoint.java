package org.freemason.pluto.common.endpoint;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.freemason.pluto.common.handler.ChannelHandlerInitializer;

/**
 * Netty服务器端点
 * @author wangran
 * @since 1.0
 */
public class NettyServerEndpoint extends AbstractEndpoint{

    private int port;
    private ServerBootstrap bootstrap;
    public NettyServerEndpoint(int port, ChannelInboundHandler...handlers) {
        this.port = port;
        bootstrap = new ServerBootstrap();
        bootstrap.group(super.bossGroup, super.workerGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(new ChannelHandlerInitializer(handlers));
        start();
    }

    @Override
    protected void start() {

        try {


            channel = bootstrap.bind(port).sync().channel();
        } catch (InterruptedException e) {
            //ignore
        }
    }
}
