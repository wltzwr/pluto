package org.freemason.pluto.common.model;


public class FailureResponse extends AbstractResponse{
    private final Exception e;

    public FailureResponse(InvokeRequest request, Exception e) {
        super(request, false);
        this.e = e;
    }

    @Override
    public Object getResult() {
        throw new UnsupportedOperationException("Failure response does not has result.");
    }

    @Override
    public String exceptionMessage() {
        return e.getMessage();
    }
}
