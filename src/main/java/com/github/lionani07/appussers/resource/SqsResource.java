package com.github.lionani07.appussers.resource;

import com.github.lionani07.appussers.service.AmazonSQSService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sqs")
@RequiredArgsConstructor
public class SqsResource {

    private final AmazonSQSService amazonSQSService;

    @GetMapping("/messages")
    public Message<?> messages() {
        return amazonSQSService.getMessages();
    }
}
