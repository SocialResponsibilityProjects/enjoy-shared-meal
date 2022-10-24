package com.srp.enjoysharedmeal.controller;

import com.srp.enjoysharedmeal.model.entity.Post;
import com.srp.enjoysharedmeal.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post sharePost(@RequestBody Post sharePostRequest) {
        return postService.share(sharePostRequest);
    }

}
