package com.awesome.testing.request.edit;

import com.awesome.testing.request.edit.dto.EditDto;
import com.awesome.testing.request.edit.dto.Roles;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.gatling.javaapi.core.Session;
import io.gatling.javaapi.http.HttpRequestActionBuilder;

import java.util.List;
import java.util.function.Function;

import static com.awesome.testing.util.RandomUtil.randomString;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class EditUser {

    private static final Function<Session, String> editRequestBody = session -> {
        EditDto editDto = EditDto.builder()
                .email(session.getString("email"))
                .firstName(randomString(10))
                .lastName(randomString(10))
                .username(randomString(10))
                .roles(List.of(Roles.ROLE_CLIENT))
                .build();

        try {
            return new ObjectMapper().writeValueAsString(editDto);
        } catch (JsonProcessingException e) {
            throw  new RuntimeException();
        }
    };

    public static final HttpRequestActionBuilder EDIT_USER_REQUEST =
            http("Edit user request")
                    .put("/users/" + "#{username}")
                    .header("Authorization", "Bearer " + "#{token}")
                    .body(StringBody(editRequestBody))
                    .check(status().is(200));


}
