package com.awesome.testing.http;

import com.awesome.testing.dto.Roles;
import com.awesome.testing.dto.UserEditDto;
import io.gatling.javaapi.core.Session;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.SneakyThrows;

import java.util.List;

import static com.awesome.testing.core.Jackson.getObjectMapper;
import static com.awesome.testing.feeder.FakerHelper.FAKER;
import static com.awesome.testing.feeder.FakerHelper.generateValid;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class PutUserEdit {

    public static final HttpRequestActionBuilder EDIT_USER =
            http("User edit request")
                    .put("/users/#{username}")
                    .header("Authorization", "Bearer #{token}")
                    .body(StringBody(PutUserEdit::buildEditRequestBody))
                    .check(status().is(200));

    @SneakyThrows
    private static String buildEditRequestBody(Session session) {
        UserEditDto userEditDto = UserEditDto.builder()
                .roles(List.of(Roles.ROLE_ADMIN, Roles.ROLE_CLIENT))
                .username(session.getString("username"))
                .email(FAKER.internet().emailAddress())
                .firstName(generateValid(() -> FAKER.name().firstName()))
                .lastName(generateValid(() -> FAKER.name().lastName()))
                .build();

        return getObjectMapper().writeValueAsString(userEditDto);
    }

}
