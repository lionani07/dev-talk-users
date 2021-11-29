package com.github.lionani07.appussers.service;

import com.github.lionani07.appussers.model.User;
import com.github.lionani07.appussers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public User find(Long id) {
        return this.userRepository
                .findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }
}
