package com.awesome.testing.request;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class GetSingleUser {

    public static final HttpRequestActionBuilder GET_SINGLE_USER_REQUEST = http("Get single user: GET /users/${username}")
            .get("/users/#{username}")
            .header("Authorization", "Bearer #{token}")
            .check(status().is(200));
}