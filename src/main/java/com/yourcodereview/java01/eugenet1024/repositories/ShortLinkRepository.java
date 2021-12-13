package com.yourcodereview.java01.eugenet1024.repositories;

import com.yourcodereview.java01.eugenet1024.entities.ShortLink;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortLinkRepository extends PagingAndSortingRepository<ShortLink, Long> {

}
