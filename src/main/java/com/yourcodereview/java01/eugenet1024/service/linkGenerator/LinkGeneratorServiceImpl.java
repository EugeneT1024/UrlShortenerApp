package com.yourcodereview.java01.eugenet1024.service.linkGenerator;

import com.yourcodereview.java01.eugenet1024.api.linkGenerator.GenerateLinkRequest;
import com.yourcodereview.java01.eugenet1024.api.linkGenerator.GenerateLinkResponse;
import org.springframework.stereotype.Service;

@Service
public class LinkGeneratorServiceImpl implements LinkGeneratorService {

    @Override
    public GenerateLinkResponse generateLink(GenerateLinkRequest request) {
        return new GenerateLinkResponse("Stub");
    }

}
