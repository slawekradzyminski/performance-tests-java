package com.awesome.testing.core;

import io.gatling.javaapi.http.HttpProtocolBuilder;

import static com.awesome.testing.config.LocalConfig.LOCALHOST_URL;
import static io.gatling.javaapi.http.HttpDsl.http;

public class HttpConfig {

    private static final String JSON = "application/json";

    public static final HttpProtocolBuilder HTTP_CONFIG = http
            .baseUrl(LOCALHOST_URL)
            .acceptHeader(JSON)
            .contentTypeHeader(JSON);

}
