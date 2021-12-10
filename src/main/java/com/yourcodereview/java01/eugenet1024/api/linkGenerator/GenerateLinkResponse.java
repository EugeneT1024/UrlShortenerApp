package com.yourcodereview.java01.eugenet1024.api.linkGenerator;

public class GenerateLinkResponse {

    private String errorMessage;
    private String link;

    public GenerateLinkResponse() {

    }

    public GenerateLinkResponse(String link) {
        this.link = link;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
