package com.github.lionani07.appussers.service;

import com.github.lionani07.appussers.amazon_sqs_request.VideoDeleteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class AmazonSQSService {

    @Value("${cloud.aws.sqs.queues.delete_video_queue.name}")
    private String deleteVideoQueue;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    void notify(VideoDeleteRequest videoDeleteRequest) {
        this.queueMessagingTemplate.convertAndSend(this.deleteVideoQueue, videoDeleteRequest);
    }

}
