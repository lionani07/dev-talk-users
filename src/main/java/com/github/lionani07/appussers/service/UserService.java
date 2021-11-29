package com.github.lionani07.appussers.service;

import com.github.lionani07.appussers.amazon_sqs_request.VideoDeleteRequest;
import com.github.lionani07.appussers.client.VideoClient;
import com.github.lionani07.appussers.client.VideoResponse;
import com.github.lionani07.appussers.model.User;
import com.github.lionani07.appussers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final VideoClient videoClient;

    private final AmazonSQSService amazonSQSService;

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public User find(Long id) {
        final var userFound = this.userRepository
                .findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));

        final Flux<VideoResponse> videosOfUser = this.videoClient.findVideosByUser(id);
        userFound.setVideos(videosOfUser.collectList().block());
        return userFound;
    }

    public void deleteVideo(Long videoId) {
        this.amazonSQSService.notify(new VideoDeleteRequest(videoId));
    }
}
