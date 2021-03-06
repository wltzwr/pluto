package org.freemason.pluto.common.transmission.endpoint;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.freemason.pluto.common.transmission.handler.ChannelHandlerInitializer;
import org.freemason.pluto.common.transmission.handler.ClientInvocationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.ConnectException;

/**
 * Netty客户端端点
 * @author wangran
 * @since 1.0
 */
public class NettyClientEndpoint extends AbstractEndpoint implements ClientEndpoint {

    private final int port;
    private final String host;
    private Bootstrap bootstrap;

    public NettyClientEndpoint(String host, int port, ChannelInboundHandler...handlers){
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
        } catch (Exception e) {
            //ignore
            System.out.println("链接失败");
        }
    }

    @Override
    public ChannelFuture send(Object msg) {
        return channel.writeAndFlush(msg);
    }

}
