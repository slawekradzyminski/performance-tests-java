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
public class EditRequestDto {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private List<Roles> roles;

}
