package com.yourcodereview.java01.eugenet1024.services.linkGenerator;

import com.yourcodereview.java01.eugenet1024.api.linkGenerator.GenerateLinkRequest;
import com.yourcodereview.java01.eugenet1024.api.linkGenerator.GenerateLinkResponse;
import com.yourcodereview.java01.eugenet1024.entities.ShortLinkEntity;
import com.yourcodereview.java01.eugenet1024.repositories.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkGeneratorServiceImpl implements LinkGeneratorService {

    ShotLinkGenerator shotLinkGenerator;
    ShortLinkRepository shortLinkRepository;

    @Autowired
    public LinkGeneratorServiceImpl(ShotLinkGenerator shotLinkGenerator, ShortLinkRepository shortLinkRepository) {
        this.shotLinkGenerator = shotLinkGenerator;
        this.shortLinkRepository = shortLinkRepository;
    }

    @Override
    public GenerateLinkResponse generateLink(String shortLinksPath, GenerateLinkRequest request) {
        ShortLinkEntity shortLinkEntity = shortLinkRepository.save(new ShortLinkEntity(request));
        String shortLink = shotLinkGenerator.idToShortLink(shortLinkEntity.getId());
        return new GenerateLinkResponse(shortLinksPath + shortLink);
    }

}
