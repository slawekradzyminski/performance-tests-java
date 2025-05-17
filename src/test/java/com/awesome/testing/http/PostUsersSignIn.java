package com.awesome.testing.http;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.ElFileBody;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class PostUsersSignIn {

    public static final HttpRequestActionBuilder LOGIN_REQUEST = http("Admin login request")
            .post("/users/signin")
            .body(ElFileBody("bodies/adminLogin.json"))
            .check(status().is(200));

}
