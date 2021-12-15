package com.github.lionani07.appussers.client.response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "VideosClient", url = "${client.videos.url}")
public interface VideosClient {

    @GetMapping(params = "user")
    List<VideoResponse> getVideos(@RequestParam("user") Long userId);
}
