package com.github.lionani07.appussers.repository;

import com.github.lionani07.appussers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
