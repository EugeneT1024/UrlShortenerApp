package com.yourcodereview.java01.eugenet1024.services.linkRedirect;

import org.springframework.stereotype.Service;

@Service
public class LinkRedirectServiceImpl implements LinkRedirectService {

    @Override
    public String getOriginalUrlByShortLink(String shortLink) {
        return "https://yourcodereview.com/"; // TODO implement this
    }
}
