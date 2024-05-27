package com.awesome.testing.request;

import com.awesome.testing.dto.EditUserDto;
import com.awesome.testing.dto.Roles;
import io.gatling.javaapi.core.Session;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.SneakyThrows;

import java.util.List;

import static com.awesome.testing.config.LocalConfig.OBJECT_MAPPER;
import static com.awesome.testing.util.Random.getRandomEmail;
import static com.awesome.testing.util.Random.getRandomString;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class EditUser {

    public static final HttpRequestActionBuilder EDIT_USER = http("Edit user")
            .put("/users/#{username}")
            .header("Authorization", "Bearer #{token}")
            .body(StringBody(EditUser::getBody))
            .check(status().is(200));

    @SneakyThrows
    private static String getBody(Session session) {
        EditUserDto editUser = EditUserDto.builder()
                .username(session.getString("username"))
                .firstName(getRandomString())
                .lastName(getRandomString())
                .email(getRandomEmail())
                .roles(List.of(Roles.ROLE_ADMIN, Roles.ROLE_CLIENT))
                .build();

        return OBJECT_MAPPER.writeValueAsString(editUser);
    }
}
