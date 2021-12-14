package com.yourcodereview.java01.eugenet1024.entities;

import com.yourcodereview.java01.eugenet1024.api.linkGenerator.GenerateLinkRequest;

import javax.persistence.*;

@Entity
public class ShortLinkEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String originalUrl;

    @Column(nullable = false)
    Long countOfRequests;

    public ShortLinkEntity() {
    }

    public ShortLinkEntity(String originalUrl) {
        this.originalUrl = originalUrl;
        this.countOfRequests = 0L;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Long getCountOfRequests() {
        return countOfRequests;
    }

    public void setCountOfRequests(Long countOfRequests) {
        this.countOfRequests = countOfRequests;
    }
}
