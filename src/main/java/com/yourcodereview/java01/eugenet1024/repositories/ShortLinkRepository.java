package com.yourcodereview.java01.eugenet1024.repositories;

import com.yourcodereview.java01.eugenet1024.entities.ShortLinkEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortLinkRepository extends PagingAndSortingRepository<ShortLinkEntity, Integer> {

    Long countByCountOfRequestsGreaterThan(Long countOfRequests);

}
