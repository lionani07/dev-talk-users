package com.github.lionani07.appussers.service;

import com.github.lionani07.appussers.amazon_sqs_request.VideoCreationRequest;

public interface VideoCreator {

    public void create(final VideoCreationRequest videoCreationRequest);
}
