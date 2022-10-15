package com.srp.enjoysharedmeal.service.impl;

import com.srp.enjoysharedmeal.model.entity.Post;
import com.srp.enjoysharedmeal.repo.PostRepository;
import com.srp.enjoysharedmeal.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post share(Post post) {
        return postRepository.save(post);
    }
}
