package com.yourcodereview.java01.eugenet1024.api.statistics;

import com.yourcodereview.java01.eugenet1024.entities.ShortLinkEntity;

public class ShortLinkStatisticsDto {

    private String errorMessage;

    private String link;
    private String original;
    private long rank;
    private long count;

    public ShortLinkStatisticsDto() {
    }

    public ShortLinkStatisticsDto(ShortLinkEntity entity) {
        this.link = "stub";
        this.original = entity.getOriginalUrl();
        this.rank = 0L;
        this.count = entity.getCountOfRequests();
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

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
