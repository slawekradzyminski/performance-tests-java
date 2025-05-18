package com.awesome.testing.http;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class GetCart {

    public static final HttpRequestActionBuilder GET_CART =
            http("Get cart")
                    .get("/api/cart")
                    .header("Authorization", "Bearer #{token}")
                    .check(status().is(200));

}
