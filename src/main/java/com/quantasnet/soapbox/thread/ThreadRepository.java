package com.quantasnet.soapbox.thread;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface ThreadRepository extends ReactiveCrudRepository<Thread, Long> {
    Flux<Thread> findAllByBoxId(Long boxId, Pageable pageable);
}
