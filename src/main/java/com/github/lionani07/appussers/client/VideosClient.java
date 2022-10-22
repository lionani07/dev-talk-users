package com.github.lionani07.appussers.client;

import com.github.lionani07.appussers.amazon_sqs_request.VideoCreationRequest;
import com.github.lionani07.appussers.client.response.VideoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "VideosClient", url = "${client.videos.url}")
public interface VideosClient {

    @GetMapping(params = "user")
    List<VideoResponse> getVideos(@RequestParam("user") Long userId);

    @PostMapping
    void create(@RequestBody VideoCreationRequest videoCreationRequest);
}
