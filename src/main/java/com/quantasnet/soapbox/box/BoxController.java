package com.quantasnet.soapbox.box;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/box")
public class BoxController {
    
    private final BoxService boxService;

    BoxController(final BoxService boxService) {
        this.boxService = boxService;
    }

    @GetMapping
    public Mono<Page<Box>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return this.boxService.getBoxesPaged(PageRequest.of(page, size));
    }
}
