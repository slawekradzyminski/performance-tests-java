package com.awesome.testing.request;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.ElFileBody;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Register {

    public static final HttpRequestActionBuilder REGISTER_REQUEST =
            http("Register request")
                    .post("/users/signup")
                    .body(ElFileBody("bodies/register.json"))
                    .check(status().is(201));

}
