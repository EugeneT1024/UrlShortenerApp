package com.yourcodereview.java01.eugenet1024.api.statistics;

import java.util.ArrayList;
import java.util.List;

public class OverallStatisticsDto {

    private String errorMessage;
    private List<ShortLinkStatisticsDto> statistics;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<ShortLinkStatisticsDto> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<ShortLinkStatisticsDto> statistics) {
        this.statistics = statistics;
    }

    public void addStatisticsItem(ShortLinkStatisticsDto item) {
        if (this.statistics == null) {
            this.statistics = new ArrayList<>();
        }
        this.statistics.add(item);
    }
}
