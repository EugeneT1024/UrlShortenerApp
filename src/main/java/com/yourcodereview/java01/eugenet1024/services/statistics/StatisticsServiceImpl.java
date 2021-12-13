package com.yourcodereview.java01.eugenet1024.services.statistics;

import com.yourcodereview.java01.eugenet1024.api.statistics.OverallStatisticsDto;
import com.yourcodereview.java01.eugenet1024.api.statistics.ShortLinkStatisticsDto;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Override
    public ShortLinkStatisticsDto getStatisticsForShortLink(String shortLink) {
        return new ShortLinkStatisticsDto();
    }

    @Override
    public OverallStatisticsDto getOverallStatistics() {
        return new OverallStatisticsDto();
    }
}
