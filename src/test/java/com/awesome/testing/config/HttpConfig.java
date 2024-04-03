package com.awesome.testing.config;

import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.http.HttpDsl.http;

public class HttpConfig {

    private static final String JSON = "application/json";

    public static final HttpProtocolBuilder HTTP_PROTOCOL = http
            .baseUrl("http://localhost:4001")
            .acceptHeader(JSON)
            .contentTypeHeader(JSON);

}
