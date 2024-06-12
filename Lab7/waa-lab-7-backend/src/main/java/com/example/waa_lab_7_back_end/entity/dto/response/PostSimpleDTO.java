package com.example.waa_lab_7_back_end.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostSimpleDTO {
    long id;
    String title;
    String content;
    String author;
}
