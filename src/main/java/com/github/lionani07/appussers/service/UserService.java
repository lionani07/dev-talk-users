package com.github.lionani07.appussers.service;

import com.github.lionani07.appussers.amazon_sqs_request.VideoCreationRequest;
import com.github.lionani07.appussers.client.request.VideoRequest;
import com.github.lionani07.appussers.client.response.VideoResponse;
import com.github.lionani07.appussers.client.response.VideosClient;
import com.github.lionani07.appussers.model.User;
import com.github.lionani07.appussers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final VideosClient videosClient;

    private final AmazonSQSService amazonSQSService;

    public User save(final User user) {
        return this.userRepository.save(user);
    }

    public void createVideo(final Long userId, final VideoRequest videoRequest) {
        this.amazonSQSService.notify(VideoCreationRequest.of(userId, videoRequest));
    }

    public User find(final Long id) {
        final var userFound = this.userRepository
                .findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));

        final List<VideoResponse> videos = this.videosClient.getVideos(id);
        userFound.setVideos(videos);

        return userFound;
    }

}
