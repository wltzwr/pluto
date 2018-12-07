package org.freemason.pluto.common.model;


public class SuccessResponse extends AbstractResponse{

    private Object result;

    public SuccessResponse(InvokeRequest invokeRequest, Object result) {
        super(invokeRequest, true);
        this.result = result;
    }

    @Override
    public Object getResult() {
        return result;
    }


    @Override
    public final String exceptionMessage() {
        return null;
    }
}
