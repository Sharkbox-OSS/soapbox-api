package com.quantasnet.soapbox.thread;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/thread")
public class ThreadController {
    
    private final ThreadService threadService;

    ThreadController(final ThreadService threadService) {
        this.threadService = threadService;
    }

    @GetMapping("/all/{threadId}")
    public Mono<Page<Thread>> getAll(@PathVariable Long threadId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return this.threadService.getThreadsForBoxPaged(threadId, PageRequest.of(page, size));
    }
}
