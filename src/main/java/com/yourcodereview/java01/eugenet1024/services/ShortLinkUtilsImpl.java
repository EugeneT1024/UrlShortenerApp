package com.yourcodereview.java01.eugenet1024.services;

import org.springframework.stereotype.Service;

@Service
public class ShortLinkUtilsImpl implements ShortLinkUtils {

    private static final String ALPHABET =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @Override
    public String idToShortLink(Integer id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id of Entity must be > 0");
        }

        id = id -1;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append(ALPHABET.charAt(id % 62));
            id = id / 62;
        } while (id > 0);

        return stringBuilder.reverse().toString();
    }

    @Override
    public Integer shortLinkToId(String shortLink) {
        int id = 0;

        for (int i = 0; i < shortLink.length(); i++) {
            if ('a' <= shortLink.charAt(i) && shortLink.charAt(i) <= 'z') {
                id = id * 62 + shortLink.charAt(i) - 'a';

            } else if ('A' <= shortLink.charAt(i) && shortLink.charAt(i) <= 'Z') {
                id = id * 62 + shortLink.charAt(i) - 'A' + 26;

            } else if ('0' <= shortLink.charAt(i) && shortLink.charAt(i) <= '9') {
                id = id * 62 + shortLink.charAt(i) - '0' + 52;
            }
        }
        return id;
    }
}
