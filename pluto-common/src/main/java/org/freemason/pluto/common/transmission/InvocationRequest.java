package org.freemason.pluto.common.transmission;

import org.freemason.pluto.common.utils.IDUtils;
import org.springframework.util.Assert;

import java.lang.reflect.Method;

import static org.freemason.pluto.common.transmission.protocol.ETFOProtocol.BIZ_SIGN;

public class InvocationRequest extends AbstractMessage<RequestBody, String>{

    public InvocationRequest(String id, RequestBody body) {
        super(id, BIZ_SIGN);
        Assert.notNull(body, "parameter must not be null.");
        this.body = body;
    }

    public InvocationRequest(RequestBody body) {
        this(IDUtils.uuid(), body);
    }

    public InvocationRequest(Method method, Object[] args) {
        this(new RequestBody(method, args));
    }
}
