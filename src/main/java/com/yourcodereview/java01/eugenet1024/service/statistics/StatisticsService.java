package com.yourcodereview.java01.eugenet1024.service.statistics;

import com.yourcodereview.java01.eugenet1024.api.statistics.OverallStatisticsDto;
import com.yourcodereview.java01.eugenet1024.api.statistics.ShortLinkStatisticsDto;

public interface StatisticsService {

    ShortLinkStatisticsDto getStatisticsForShortLink(String shortLink);

    OverallStatisticsDto getOverallStatistics();
}
