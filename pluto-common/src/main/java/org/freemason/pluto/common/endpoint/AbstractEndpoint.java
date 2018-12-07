package org.freemason.pluto.common.endpoint;

import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Netty抽象端点
 * @author wangran
 * @since 1.0
 */
public abstract class AbstractEndpoint implements Endpoint{

    protected Channel channel;
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    protected abstract void start();

    @Override
    public final Channel channel(){
        return channel;
    }

    @Override
    public final void close() {
        if (channel != null && channel.isOpen()){
            channel.close();
            channel.disconnect();
        }
    }
}
