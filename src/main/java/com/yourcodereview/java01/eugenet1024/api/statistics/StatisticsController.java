package com.yourcodereview.java01.eugenet1024.api.statistics;

import com.yourcodereview.java01.eugenet1024.services.statistics.StatisticsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

    private static final String STATS_PATH = "/stats/";
    private static final String MESSAGE_500 = "Unexpected Error. Please contact the application developers";
    private static final Logger LOGGER = LogManager.getLogger();

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(value = STATS_PATH + "{shortLink}", method = RequestMethod.GET)
    public ResponseEntity<ShortLinkStatisticsDto> getStatisticsForShortLink(@PathVariable String shortLink) {

        try {
            ShortLinkStatisticsDto responseBody = statisticsService.getStatisticsForShortLink(shortLink);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            ShortLinkStatisticsDto responseBody = new ShortLinkStatisticsDto();
            responseBody.setErrorMessage(MESSAGE_500);
            return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = STATS_PATH, method = RequestMethod.GET)
    public ResponseEntity<OverallStatisticsDto> getOverallStatistics() {

        try {
            OverallStatisticsDto responseBody = statisticsService.getOverallStatistics();
            return new ResponseEntity<>(responseBody, HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            OverallStatisticsDto responseBody = new OverallStatisticsDto();
            responseBody.setErrorMessage(MESSAGE_500);
            return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
