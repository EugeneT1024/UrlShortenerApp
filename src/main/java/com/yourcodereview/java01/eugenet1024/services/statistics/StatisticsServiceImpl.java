package com.yourcodereview.java01.eugenet1024.services.statistics;

import com.yourcodereview.java01.eugenet1024.api.statistics.OverallStatisticsDto;
import com.yourcodereview.java01.eugenet1024.api.statistics.ShortLinkStatisticsDto;
import com.yourcodereview.java01.eugenet1024.entities.ShortLinkEntity;
import com.yourcodereview.java01.eugenet1024.entities.ShortLinkEntity_;
import com.yourcodereview.java01.eugenet1024.repositories.ShortLinkRepository;
import com.yourcodereview.java01.eugenet1024.services.ShortLinkUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private static final Logger LOGGER = LogManager.getLogger();

    private final ShortLinkUtils shortLinkUtils;
    private final ShortLinkRepository shortLinkRepository;

    @Autowired
    public StatisticsServiceImpl(ShortLinkUtils shortLinkUtils, ShortLinkRepository shortLinkRepository) {
        this.shortLinkUtils = shortLinkUtils;
        this.shortLinkRepository = shortLinkRepository;
    }

    @Override
    public ShortLinkStatisticsDto getStatisticsForShortLink(String shortLink) {
        Integer id = shortLinkUtils.shortLinkToId(shortLink);

        try {
            ShortLinkEntity shortLinkEntity =
                shortLinkRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("ShortLinkEntity not found by id = " + id));

            long countOfRequests = shortLinkEntity.getCountOfRequests();
            Long rank = shortLinkRepository.countByCountOfRequestsGreaterThan(countOfRequests) + 1; // если ничего нет - значит первое место

            return createStatisticsForLink(shortLink, shortLinkEntity, rank);

        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw new EntityNotFoundException("Short link is not registered in our service: " + shortLink);
        }
    }

    @Override
    public OverallStatisticsDto getOverallStatistics(int pageNumber, int countOfItems) {
        Pageable pageRequest =
            PageRequest.of(pageNumber, countOfItems, Sort.by(ShortLinkEntity_.countOfRequests.getName()).descending());
        Page<ShortLinkEntity> page = shortLinkRepository.findAll(pageRequest);

        return createOverallStatistics(page);
    }

    private ShortLinkStatisticsDto createStatisticsForLink(String shortLink, ShortLinkEntity shortLinkEntity, Long rank) {
        ShortLinkStatisticsDto response = new ShortLinkStatisticsDto();
        response.setLink(shortLink);
        response.setOriginal(shortLinkEntity.getOriginalUrl());
        response.setRank(rank);
        response.setCount(shortLinkEntity.getCountOfRequests());

        return response;
    }

    private OverallStatisticsDto createOverallStatistics(Page<ShortLinkEntity> page) {
        OverallStatisticsDto response = new OverallStatisticsDto();
        int pageNumber = page.getNumber();
        int pageSize = page.getSize();

        if (!page.hasContent()) {
            response.setErrorMessage("Данные не найдены. page = " + pageNumber + ", count = " + pageSize);
        }

        for (int i = 0; i < page.getContent().size(); i++) {
            ShortLinkEntity entity = page.getContent().get(i);

            ShortLinkStatisticsDto item = new ShortLinkStatisticsDto();
            item.setLink(shortLinkUtils.idToShortLink(entity.getId()));
            item.setOriginal(entity.getOriginalUrl());
            item.setRank(calculateRank(pageNumber, pageSize, i));
            item.setCount(entity.getCountOfRequests());
            response.addStatisticsItem(item);
        }
        return response;
    }

    private Long calculateRank(int pageNumber, int pageSize, int positionOnPage) {
        return (long) pageNumber * pageSize + positionOnPage + 1; // Нумерация идет с нуля, надо показывать с 1
    }
}
