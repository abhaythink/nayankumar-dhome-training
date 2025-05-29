package com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegration.service;

import com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegration.entity.Post;
import com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegration.response.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final WebClient webClient;

    public Mono<ApiResponse<List<Post>>> getAllPosts() {
        return webClient
                .get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(Post.class)
                .retryWhen(
                        Retry.backoff(3, Duration.ofSeconds(2))
                                .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> retrySignal.failure())
                )
                .collectList()
                .map(posts -> ApiResponse.success(posts, "Posts fetched successfully", HttpStatus.OK))
                .onErrorResume(e -> {
                    System.err.println("Error fetching posts after retry: " + e.getMessage());
                    return Mono.just(ApiResponse.error("Failed to fetch posts", HttpStatus.SERVICE_UNAVAILABLE));
                });
    }
}
