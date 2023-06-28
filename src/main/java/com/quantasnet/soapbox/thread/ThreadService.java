package com.quantasnet.soapbox.thread;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class ThreadService {
    
    private final ThreadRepository threadRepository;

    ThreadService(final ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }

    public Mono<Page<Thread>> getThreadsForBoxPaged(Long boxId, PageRequest pageRequest) {
        return this.threadRepository.findAllByBoxId(boxId, pageRequest)
            .collectList()
            .zipWith(this.threadRepository.count())
            .map(tuple -> new PageImpl<>(tuple.getT1(), pageRequest, tuple.getT2()));
    }
}
