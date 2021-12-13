package com.yourcodereview.java01.eugenet1024.services.linkGenerator;

import com.yourcodereview.java01.eugenet1024.api.linkGenerator.GenerateLinkRequest;
import com.yourcodereview.java01.eugenet1024.api.linkGenerator.GenerateLinkResponse;

public interface LinkGeneratorService {

    GenerateLinkResponse generateLink(GenerateLinkRequest request);

}
