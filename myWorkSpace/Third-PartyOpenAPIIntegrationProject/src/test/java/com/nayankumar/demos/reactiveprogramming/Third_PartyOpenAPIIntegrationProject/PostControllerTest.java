package com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegrationProject;

import com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegrationProject.controller.PostController;
import com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegrationProject.entity.Post;
import com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegrationProject.response.ApiResponse;
import com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegrationProject.service.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@WebFluxTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private PostService service;

    @Test
    public void testGetExternalPosts() {
        Post mockPost = new Post();
        mockPost.setId(1);
        mockPost.setUserId(1);
        mockPost.setTitle("Test Title");
        mockPost.setBody("Test Body");

        List<Post> postList = Collections.singletonList(mockPost);
        ApiResponse<List<Post>> response = ApiResponse.success(postList, "Posts fetched successfully", HttpStatus.OK);

        Mockito.when(service.getAllPosts()).thenReturn(Mono.just(response));

        webClient.get()
                .uri("/posts")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.success").isEqualTo(true)
                .jsonPath("$.message").isEqualTo("Posts fetched successfully")
                .jsonPath("$.data[0].id").isEqualTo(1)
                .jsonPath("$.data[0].title").isEqualTo("Test Title");
    }
}