package org.freemason.pluto.common.model;


public class FailureResponse extends AbstractResponse{

    private final String errorMessage;

    public FailureResponse(InvokeRequest request, Exception e) {
        super(request, false);
        this.errorMessage = e == null ? "unknown exception caused." : e.getMessage();
    }

    @Override
    public Object getResult() {
        return null;
    }

    @Override
    public String exceptionMessage() {
        return errorMessage;
    }
}
