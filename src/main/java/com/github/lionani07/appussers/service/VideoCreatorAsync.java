package com.github.lionani07.appussers.service;

import com.github.lionani07.appussers.amazon_sqs_request.VideoCreationRequest;
import org.springframework.stereotype.Component;

@Component("videoCreatorAsync")
public class VideoCreatorAsync implements VideoCreator{

//    @Autowired
    private AmazonSQSService amazonSQSService;

    @Override
    public void create(VideoCreationRequest videoCreationRequest) {
        this.amazonSQSService.notify(videoCreationRequest);
    }
}
