package com.awesome.testing.http;

import com.awesome.testing.dto.EditDto;
import com.awesome.testing.dto.Roles;
import io.gatling.javaapi.core.Session;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.SneakyThrows;

import static com.awesome.testing.core.Jackson.getObjectMapper;
import static com.awesome.testing.feeder.UserFeeder.*;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class EditUser {

    public static final HttpRequestActionBuilder EDIT_USER_REQUEST =
            http("Edit user request")
                    .put("/users/#{username}")
                    .header("Authorization", "Bearer " + "#{token}")
                    .body(StringBody(EditUser::getBody))
                    .check(status().is(200));

    @SneakyThrows
    public static String getBody(Session session) {
        EditDto editDto = EditDto.builder()
                .username(session.getString("username"))
                .roles(new Roles[]{Roles.ROLE_ADMIN, Roles.ROLE_CLIENT})
                .firstName(generateFirstName())
                .lastName(generateLastName())
                .email(generateEmail())
                .build();

        return getObjectMapper().writeValueAsString(editDto);
    }
}
