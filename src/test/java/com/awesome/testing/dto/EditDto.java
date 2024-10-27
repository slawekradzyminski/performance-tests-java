package com.awesome.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EditDto {

    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private Roles[] roles;

}
