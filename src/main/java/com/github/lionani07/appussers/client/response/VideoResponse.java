package com.github.lionani07.appussers.client.response;

import lombok.Data;

@Data
public class VideoResponse {

    private Long id;
    private String name;
    private String visibility;
    private String description;
    private String url;

}
