package com.nayankumar.demos.reactiveprogramming.Third_PartyOpenAPIIntegrationProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {

    private Integer id;
    private Integer userId;
    private String title;
    private String body;

}
