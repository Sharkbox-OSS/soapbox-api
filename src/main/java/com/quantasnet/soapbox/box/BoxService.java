package com.quantasnet.soapbox.box;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class BoxService {
    
    private final BoxRepository boxRepository;

    BoxService(final BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    public Mono<Page<Box>> getBoxesPaged(PageRequest pageRequest) {
        return this.boxRepository.findAllBy(pageRequest)
            .collectList()
            .zipWith(this.boxRepository.count())
            .map(tuple -> new PageImpl<>(tuple.getT1(), pageRequest, tuple.getT2()));
    }
}
