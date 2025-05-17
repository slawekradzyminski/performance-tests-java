package com.awesome.testing.http;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class GetProducts {

    public static final HttpRequestActionBuilder GET_PRODUCTS =
            http("Get products")
                    .get("/api/products")
                    .header("Authorization", "Bearer #{token}")
                    .check(status().is(200))
                    .check(jsonPath("$[*].id").findRandom().saveAs("productId"));

}
