package com.awesome.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEditDto {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private List<Roles> roles;

}
