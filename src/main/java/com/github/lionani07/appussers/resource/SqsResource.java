package com.github.lionani07.appussers.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sqs")
@RequiredArgsConstructor
public class SqsResource {

//    private final AmazonSQSService amazonSQSService;
//
//    @GetMapping("/messages")
//    public Message<?> messages() {
//        return amazonSQSService.getMessages();
//    }
}
