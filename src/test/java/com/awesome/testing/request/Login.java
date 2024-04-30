package com.awesome.testing.request;

import com.awesome.testing.dto.LoginRequestDto;
import io.gatling.javaapi.core.Body;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.SneakyThrows;

import static com.awesome.testing.config.LocalConfig.OBJECT_MAPPER;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Login {

    public static final HttpRequestActionBuilder LOGIN_REQUEST = login(ElFileBody("bodies/login.json"));

    public static final HttpRequestActionBuilder ADMIN_LOGIN_REQUEST = login(StringBody(getAdminLoginBody()));

    private static HttpRequestActionBuilder login(Body.WithString body) {
        return http("Login: POST /users/signin")
                .post("/users/signin")
                .body(body)
                .check(status().is(200))
                .check(jsonPath("$.token").exists().saveAs("token"));
    }

    @SneakyThrows
    private static String getAdminLoginBody() {
        LoginRequestDto loginRequestDto = new LoginRequestDto("admin", "admin");
        return OBJECT_MAPPER.writeValueAsString(loginRequestDto);
    }

}
