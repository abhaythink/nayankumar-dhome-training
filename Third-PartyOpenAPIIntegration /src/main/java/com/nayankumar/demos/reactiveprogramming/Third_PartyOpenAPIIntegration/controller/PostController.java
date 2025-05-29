package com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegration.controller;

import com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegration.entity.Post;
import com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegration.response.ApiResponse;
import com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegration.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    @GetMapping
    public Mono<ResponseEntity<ApiResponse<List<Post>>>> getExternalPosts() {
        return service.getAllPosts()
                .map(response -> ResponseEntity.status(response.getStatusCode()).body(response));
    }
}
