package com.github.lionani07.appussers.resource;

import com.github.lionani07.appussers.model.User;
import com.github.lionani07.appussers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        final var userCreated = this.userService.save(user);

        final var location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(userCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable final Long id) {
        final var userFound = this.userService.find(id);

        //TODO FIND VIDEOS ASYNC

        return ResponseEntity.ok(userFound);
    }
}

