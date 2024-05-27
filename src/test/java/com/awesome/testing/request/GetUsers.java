package com.awesome.testing.request;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class GetUsers {

    public static final HttpRequestActionBuilder GET_ALL_USERS_REQUEST =
            http("Get all users request")
                    .get("/users")
                    .header("Authorization", "Bearer " + "#{token}")
                    .check(status().is(200));

    public static final HttpRequestActionBuilder GET_ALL_USERS_AS_ADMIN_REQUEST =
            GET_ALL_USERS_REQUEST
                    .check(jsonPath("$..username").findAll().optional().saveAs("usernames"));

}
