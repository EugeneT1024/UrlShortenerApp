package com.yourcodereview.java01.eugenet1024.api.statistics;

import com.yourcodereview.java01.eugenet1024.entities.ShortLinkEntity;

public class ShortLinkStatisticsDto {

    private String errorMessage;

    private String link;
    private String original;
    private Long rank;
    private Long count;

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

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
