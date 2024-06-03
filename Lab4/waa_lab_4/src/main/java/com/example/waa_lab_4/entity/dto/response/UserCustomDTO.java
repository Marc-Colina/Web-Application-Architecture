package com.example.waa_lab_4.entity.dto.response;
//This DTO is for handling Users with the number of posts they have.

import com.example.waa_lab_4.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserCustomDTO {
    User user;
    long postCount;
}
