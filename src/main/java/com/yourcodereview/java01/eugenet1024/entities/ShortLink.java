package com.yourcodereview.java01.eugenet1024.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShortLink {

    @Id()
    Long id;

    @Column(nullable = false)
    String originalUrl;

    @Column(nullable = false)
    Long countOfRequests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
