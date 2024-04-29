package com.awesome.testing.request;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class GetUsers {

    public static final HttpRequestActionBuilder GET_USERS_REQUEST = http("Get Users: GET /users")
            .get("/users")
            .header("Authorization", "Bearer #{token}")
            .check(status().is(200));
}