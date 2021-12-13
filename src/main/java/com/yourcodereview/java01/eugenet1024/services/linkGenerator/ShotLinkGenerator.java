package com.yourcodereview.java01.eugenet1024.services.linkGenerator;

public interface ShotLinkGenerator {

    String idToShortLink(Integer id);

    Integer shortLinkToId(String shortLink);

}
