package com.awesome.testing.http;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.ElFileBody;
import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Login {

    public static final HttpRequestActionBuilder LOGIN_REQUEST =
            http("Login request")
                    .post("/users/signin")
                    .body(ElFileBody("bodies/login.json"))
                    .check(status().is(200))
                    .check(jsonPath("$.token").exists().saveAs("token"));

}
