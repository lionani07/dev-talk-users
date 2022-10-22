package com.github.lionani07.appussers.service;

import com.github.lionani07.appussers.amazon_sqs_request.VideoCreationRequest;
import com.github.lionani07.appussers.client.VideosClient;
import com.github.lionani07.appussers.exceptions.AppVideosComunicationException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("videoCreatorSync")
public class VideoCreatorSync implements VideoCreator{

    @Autowired
    private VideosClient videosClient;

    @Override
    public void create(VideoCreationRequest videoCreationRequest) {
        try {
            this.videosClient.create(videoCreationRequest);
        } catch (FeignException e) {
            throw new AppVideosComunicationException("Nao foi possivel criar o video nesse momento");
        }
    }
}
