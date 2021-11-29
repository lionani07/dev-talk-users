package com.github.lionani07.appussers.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VideoResponse {

    private Long id;

    @JsonProperty("user_id")
    private Long userId;
    private String name;
    private String url;

}
