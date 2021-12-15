package com.github.lionani07.appussers.model;

import com.github.lionani07.appussers.client.response.VideoResponse;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Transient
    private List<VideoResponse> videos = new ArrayList<>();
}
