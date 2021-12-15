package com.github.lionani07.appussers.service;

import com.github.lionani07.appussers.amazon_sqs_request.VideoCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class AmazonSQSService {

    @Value("${cloud.aws.sqs.queues.create_video_queue.name}")
    private String createVideoQueue;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    void notify(final VideoCreationRequest videoCreationRequest) {
        this.queueMessagingTemplate.convertAndSend(this.createVideoQueue, videoCreationRequest);
    }

    public Message<?> getMessages() {
        return this.queueMessagingTemplate.receive(createVideoQueue);
    }

}
