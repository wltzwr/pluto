package org.freemason.pluto.common.model;


public class SuccessfulInvokeResponse extends AbstractResponse{

    private Object result;

    public SuccessfulInvokeResponse(InvokeRequest invokeRequest, Object result) {
        super(invokeRequest, true);
        this.result = result;
    }

    @Override
    public Object getResult() {
        return result;
    }


    @Override
    public final String exceptionMessage() {
        throw new UnsupportedOperationException("Successful response does not has any exception.");
    }
}
