package com.yourcodereview.java01.eugenet1024.api.statistics;

import com.yourcodereview.java01.eugenet1024.services.statistics.StatisticsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
public class StatisticsController {

    private static final String STATS_PATH = "/stats";
    private static final String MESSAGE_500 = "Unexpected Error. Please contact the application developers";
    private static final Logger LOGGER = LogManager.getLogger();

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(value = STATS_PATH + "/{shortLink}", method = RequestMethod.GET)
    public ResponseEntity<ShortLinkStatisticsDto> getStatisticsForShortLink(@PathVariable String shortLink) {

        try {
            ShortLinkStatisticsDto responseBody = statisticsService.getStatisticsForShortLink(shortLink);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage());
            ShortLinkStatisticsDto responseBody = new ShortLinkStatisticsDto();
            responseBody.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            ShortLinkStatisticsDto responseBody = new ShortLinkStatisticsDto();
            responseBody.setErrorMessage(MESSAGE_500);
            return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = STATS_PATH, method = RequestMethod.GET)
    public ResponseEntity<OverallStatisticsDto> getOverallStatistics(
        @Min(value = 0, message = "Page number must be >= 0") @RequestParam int page,
        @Min(value = 1, message = "Count of items per page must be > 0")
        @Max(value = 100, message = "Count of items must be <= 100") @RequestParam int count) {

        try {
            OverallStatisticsDto responseBody = statisticsService.getOverallStatistics(page, count);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);

        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage());
            OverallStatisticsDto responseBody = new OverallStatisticsDto();
            responseBody.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            OverallStatisticsDto responseBody = new OverallStatisticsDto();
            responseBody.setErrorMessage(MESSAGE_500);
            return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
