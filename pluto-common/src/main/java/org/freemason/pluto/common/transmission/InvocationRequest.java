package org.freemason.pluto.common.transmission;

import org.freemason.pluto.common.core.MethodInvocationMetaData;
import org.springframework.util.Assert;

import static org.freemason.pluto.common.transmission.protocol.ETFOProtocol.INVOKE_SIGN;

public class InvocationRequest extends BaseExchange<MethodInvocationMetaData>{

    private MethodInvocationMetaData payload;

    private Object[] parameters;

    public InvocationRequest(String id, MethodInvocationMetaData payload, Object[] parameters) {
        super(id, INVOKE_SIGN);
        Assert.notNull(payload, "payload must not be null.");
        this.payload = payload;
        this.parameters = parameters;
    }

    public InvocationRequest(String id, MethodInvocationMetaData payload) {
        this(id, payload, null);
    }

    public InvocationRequest(MethodInvocationMetaData payload, Object[] parameters) {
        this(UUIDIdSupplier.get(), payload, parameters);
    }

    public InvocationRequest(MethodInvocationMetaData payload) {
        this(payload, null);
    }

    public Object[] getParameters() {
        return parameters;
    }

    @Override
    public MethodInvocationMetaData getPayload() {
        return payload;
    }



}
