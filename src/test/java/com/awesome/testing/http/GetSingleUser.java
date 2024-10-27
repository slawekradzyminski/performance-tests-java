package com.awesome.testing.http;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class GetSingleUser {

    public static final HttpRequestActionBuilder GET_SINGLE_USER_REQUEST =
            http("Get single user request")
                    .get("/users/#{username}")
                    .header("Authorization", "Bearer " + "#{token}")
                    .check(status().is(200))
                    .check(jsonPath("$.username").is(session -> session.getString("username")));
}
