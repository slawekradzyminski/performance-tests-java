package com.awesome.testing.request;

import com.awesome.testing.dto.EditRequestDto;
import com.awesome.testing.dto.Roles;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.gatling.javaapi.core.Session;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import net.datafaker.Faker;

import java.util.List;
import java.util.function.Function;

import static com.awesome.testing.config.LocalConfig.OBJECT_MAPPER;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class EditUser {

    private static final Faker FAKER = new Faker();
    
    public static final HttpRequestActionBuilder EDIT_USER_REQUEST = http("Edit user: PUT /users/{username}")
            .put("/users/#{username}")
            .body(StringBody(buildRequestBody()))
            .header("Authorization", "Bearer #{token}")
            .check(status().is(200));


    private static Function<Session, String> buildRequestBody() {
        return session -> {
            EditRequestDto editRequestDto = EditRequestDto.builder()
                    .username(session.getString("username"))
                    .firstName(session.getString("firstName"))
                    .lastName(session.getString("lastName"))
                    .roles(List.of(Roles.ROLE_ADMIN, Roles.ROLE_CLIENT))
                    .email(FAKER.internet().emailAddress())
                    .build();

            try {
                return OBJECT_MAPPER.writeValueAsString(editRequestDto);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        };
    }

}
