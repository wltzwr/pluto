package org.freemason.pluto.common.transmission;

import org.freemason.pluto.common.transmission.protocol.ETFOProtocol;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * creat time 2019/8/14
 * pluto框架端点间交互信息的抽象父类
 * @param <B>   消息体类型
 * @param <ID>  id类型
 * @author  wangran0430@gmail.com
 * @since 1.0
 */
public abstract class AbstractMessage<B, ID extends Serializable> implements Message<B, ID>{

    private final ID id;

    private final byte type;

    B body;
    //  id 和 type必须有值 且 为常量
    AbstractMessage(ID id, byte type) {
        Assert.notNull(id, "id must not be null.");
        Assert.isTrue(ETFOProtocol.TYPES.contains(type), "unknown type = [" + type + "].");
        this.id = id;
        this.type = type;
    }

    @Override
    public final ID getId() {
        return id;
    }

    @Override
    public final byte getType() {
        return type;
    }

    @Override
    public B getBody() {
        return body;
    }
}
