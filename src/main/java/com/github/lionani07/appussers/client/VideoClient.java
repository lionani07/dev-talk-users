package com.github.lionani07.appussers.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class VideoClient {

    @Value("${client.videos.url}")
    private String url;

    public Flux<VideoResponse> findVideosByUser(Long userId) {
        return WebClient.create(url)
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("user", userId)
                        .build()
                )
                .retrieve()
                .bodyToFlux(VideoResponse.class);
    }

}
