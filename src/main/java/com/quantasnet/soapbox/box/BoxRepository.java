package com.quantasnet.soapbox.box;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

interface BoxRepository extends ReactiveCrudRepository<Box, Long> {
    Flux<Box> findAllBy(Pageable pageable);
}
