package com.awesome.testing.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class EditUserDto {

    String username;
    String firstName;
    String lastName;
    String email;
    List<Roles> roles;

}
