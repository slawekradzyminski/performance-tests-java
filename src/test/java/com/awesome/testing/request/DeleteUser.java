package com.awesome.testing.request;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class DeleteUser {

    public static final HttpRequestActionBuilder DELETE_USER_REQUEST = http("Delete user")
            .delete("/users/#{username}")
            .header("Authorization", "Bearer #{token}")
            .check(status().is(204));
}
