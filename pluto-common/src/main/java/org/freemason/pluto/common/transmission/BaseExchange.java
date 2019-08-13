package org.freemason.pluto.common.transmission;

import org.freemason.pluto.common.transmission.protocol.ETFOProtocol;
import org.springframework.util.Assert;

import java.util.UUID;

public abstract class BaseExchange<T> implements Exchange<String, T>{

    protected final String id;

    protected final byte type;

    protected BaseExchange(String id, byte type) {
        Assert.notNull(id, "id must not be null.");
        Assert.isTrue(type == ETFOProtocol.HEART_BEAT_SIGN || type == ETFOProtocol.INVOKE_SIGN, "unknown type, " + type);
        this.id = id;
        this.type = type;
    }

    @Override
    public final String getId() {
        return id;
    }

    @Override
    public final byte getType() {
        return type;
    }

    static class UUIDIdSupplier{
        private UUIDIdSupplier(){}
        static String get() {
            return UUID.randomUUID().toString().replaceAll("_","");
        }
    }
}
