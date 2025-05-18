package com.awesome.testing.core;

import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.http.HttpDsl.http;

public class HttpConfig {

    private static final String JSON = "application/json";

    public static final HttpProtocolBuilder HTTP_CONFIG = http
            .baseUrl("http://localhost:4001")
            .acceptHeader(JSON)
            .contentTypeHeader(JSON);


    public static final HttpProtocolBuilder MAILHOG_HTTP_CONFIG = http
            .baseUrl("http://localhost:8025")
            .acceptHeader(JSON)
            .contentTypeHeader(JSON);

    public static final HttpProtocolBuilder WS_HTTP_PROTOCOL = http
            .baseUrl("http://localhost:4001") // Or your configurable base URL
            .wsBaseUrl("ws://localhost:4001")  // Or your configurable WS base URL
            .acceptHeader("application/json")
            .contentTypeHeader("application/json")
            .wsUnmatchedInboundMessageBufferSize(10); // Optional: buffer for unmatched messages
}
