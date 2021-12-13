package com.yourcodereview.java01.eugenet1024.services.linkRedirect;

import com.yourcodereview.java01.eugenet1024.entities.ShortLinkEntity;
import com.yourcodereview.java01.eugenet1024.repositories.ShortLinkRepository;
import com.yourcodereview.java01.eugenet1024.services.ShortLinkUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class LinkRedirectServiceImpl implements LinkRedirectService {

    public static final Logger LOGGER = LogManager.getLogger();

    private final ShortLinkUtils shortLinkUtils;
    private final ShortLinkRepository shortLinkRepository;

    @Autowired
    public LinkRedirectServiceImpl(ShortLinkUtils shortLinkUtils, ShortLinkRepository shortLinkRepository) {
        this.shortLinkUtils = shortLinkUtils;
        this.shortLinkRepository = shortLinkRepository;
    }

    @Override
    public String getOriginalUrlByShortLink(String shortLink) {
        Integer id = shortLinkUtils.shortLinkToId(shortLink);

        String originalUrl;
        try {
            ShortLinkEntity shortLinkEntity =
                shortLinkRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("ShortLinkEntity not found by id = " + id));

            originalUrl = shortLinkEntity.getOriginalUrl();

            long countOfRequests = shortLinkEntity.getCountOfRequests();
            shortLinkEntity.setCountOfRequests(++countOfRequests);
            shortLinkRepository.save(shortLinkEntity);

        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw new EntityNotFoundException("Short link is not registered in our service: " + shortLink);
        }

        return originalUrl;
    }
}
