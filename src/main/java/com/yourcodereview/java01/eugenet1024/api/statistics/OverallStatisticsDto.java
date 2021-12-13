package com.yourcodereview.java01.eugenet1024.api.statistics;

import com.yourcodereview.java01.eugenet1024.entities.ShortLinkEntity;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverallStatisticsDto {

    private String errorMessage;
    private List<ShortLinkStatisticsDto> statistics;

    public OverallStatisticsDto() {
    }

    public OverallStatisticsDto(Page<ShortLinkEntity> page) {
        page.get()
            .sorted(Comparator.comparing(ShortLinkEntity::getCountOfRequests))
            .forEach(entity -> addStatisticsItem(new ShortLinkStatisticsDto(entity)));
    }

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
