package com.awesome.testing.request;

import com.awesome.testing.dto.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.SneakyThrows;

import static com.awesome.testing.config.LocalConfig.OBJECT_MAPPER;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Login {

    public static final HttpRequestActionBuilder LOGIN_REQUEST = http("Login: POST /users/signin")
            .post("/users/signin")
            .body(ElFileBody("bodies/login.json"))
            .check(status().is(200))
            .check(jsonPath("$.token").exists().saveAs("token"));

    public static final HttpRequestActionBuilder ADMIN_LOGIN_REQUEST = http("Login: POST /users/signin")
            .post("/users/signin")
            .body(StringBody(getAdminLoginBody()))
            .check(status().is(200))
            .check(jsonPath("$.token").exists().saveAs("token"));

    @SneakyThrows
    private static String getAdminLoginBody() {
        LoginRequest loginRequest = new LoginRequest("admin", "admin");
        return OBJECT_MAPPER.writeValueAsString(loginRequest);
    }

}
