package com.awesome.testing.request.edit.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class EditDto {

    String email;
    String firstName;
    String lastName;
    String username;
    List<Roles> roles;

}
