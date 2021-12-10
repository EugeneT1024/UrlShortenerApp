package com.yourcodereview.java01.eugenet1024.api.linkGenerator;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public class GenerateLinkRequest {

    public static final String ERROR_MESSAGE = "Original URL must be not blank!";

    private String original;

    @NotBlank(message = ERROR_MESSAGE)
    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
