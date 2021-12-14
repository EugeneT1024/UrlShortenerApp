package com.yourcodereview.java01.eugenet1024.services.linkGenerator;

import com.yourcodereview.java01.eugenet1024.api.linkGenerator.GenerateLinkRequest;
import com.yourcodereview.java01.eugenet1024.api.linkGenerator.GenerateLinkResponse;
import com.yourcodereview.java01.eugenet1024.entities.ShortLinkEntity;
import com.yourcodereview.java01.eugenet1024.repositories.ShortLinkRepository;
import com.yourcodereview.java01.eugenet1024.services.ShortLinkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkGeneratorServiceImpl implements LinkGeneratorService {

    private final ShortLinkUtils shortLinkUtils;
    private final ShortLinkRepository shortLinkRepository;

    @Autowired
    public LinkGeneratorServiceImpl(ShortLinkUtils shortLinkUtils, ShortLinkRepository shortLinkRepository) {
        this.shortLinkUtils = shortLinkUtils;
        this.shortLinkRepository = shortLinkRepository;
    }

    @Override
    public GenerateLinkResponse generateLink(String shortLinksPath, GenerateLinkRequest request) {
        ShortLinkEntity shortLinkEntity = shortLinkRepository.save(new ShortLinkEntity(request.getOriginal()));
        String shortLink = shortLinkUtils.idToShortLink(shortLinkEntity.getId());
        return new GenerateLinkResponse(shortLinksPath + shortLink);
    }

}
