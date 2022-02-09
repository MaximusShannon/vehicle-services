package com.mxsi.vehiclepositiongenerator.api.model;

/**
 * Simple response with simple message needed only for current application.
 */
public class Response {

    private Status status;

    public Response(final Status status){
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
