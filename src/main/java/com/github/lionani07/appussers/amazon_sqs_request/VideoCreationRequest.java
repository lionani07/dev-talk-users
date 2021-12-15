package com.github.lionani07.appussers.amazon_sqs_request;

import com.github.lionani07.appussers.client.request.VideoRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoCreationRequest {
    private Long userId;
    private String name;
    private String visibility;
    private String description;

    public static VideoCreationRequest of(final Long userId, final VideoRequest videoRequest) {
        return VideoCreationRequest.builder()
                .userId(userId)
                .name(videoRequest.getName())
                .visibility(videoRequest.getVisibility())
                .description(videoRequest.getDescription())
                .build();
    }
}
