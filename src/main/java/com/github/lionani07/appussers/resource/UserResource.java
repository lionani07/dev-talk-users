package com.github.lionani07.appussers.resource;

import com.github.lionani07.appussers.client.request.VideoRequest;
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

    @PostMapping("/{userId}/videos")
    public ResponseEntity<String> createVideo(@PathVariable Long userId, @RequestBody VideoRequest videoRequest) {
        this.userService.createVideo(userId, videoRequest);
        return ResponseEntity.ok(String.format("Recebemos seu video %s e estamos procesando.", videoRequest.getName()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable final Long id) {
        return ResponseEntity.ok(this.userService.find(id));
    }

}

