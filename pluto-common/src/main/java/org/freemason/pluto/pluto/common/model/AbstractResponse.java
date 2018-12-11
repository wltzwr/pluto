package org.freemason.pluto.pluto.common.model;

import org.springframework.util.Assert;

public abstract class AbstractResponse implements InvokeResponse {

    private final String id;

    private final boolean success;

    protected AbstractResponse(InvokeRequest invokeRequest, boolean success) {
        Assert.notNull(invokeRequest, "invokeRequest must not be null.");
        this.id = invokeRequest.getId();
        this.success = success;
    }

    @Override
    public final String getId() {
        return id;
    }

    @Override
    public final boolean isSuccess() {
        return success;
    }
}
