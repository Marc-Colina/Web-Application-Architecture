package com.example.waa_lab_4.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostRequestDTO {
    long user_id;
    String title;
    String content;
    String author;
}
