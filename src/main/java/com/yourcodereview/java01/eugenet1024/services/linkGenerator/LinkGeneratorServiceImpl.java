package com.yourcodereview.java01.eugenet1024.services.linkGenerator;

import com.yourcodereview.java01.eugenet1024.api.linkGenerator.GenerateLinkRequest;
import com.yourcodereview.java01.eugenet1024.api.linkGenerator.GenerateLinkResponse;
import com.yourcodereview.java01.eugenet1024.repositories.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkGeneratorServiceImpl implements LinkGeneratorService {

    ShortLinkRepository shortLinkRepository;

    @Autowired
    public LinkGeneratorServiceImpl(ShortLinkRepository shortLinkRepository) {
        this.shortLinkRepository = shortLinkRepository;
    }

    @Override
    public GenerateLinkResponse generateLink(GenerateLinkRequest request) {
        return new GenerateLinkResponse("Stub");
    }

}
