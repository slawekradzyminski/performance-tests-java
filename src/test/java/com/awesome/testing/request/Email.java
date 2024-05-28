package com.awesome.testing.request;

import com.awesome.testing.dto.EmailDto;
import io.gatling.javaapi.core.Session;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.SneakyThrows;

import static com.awesome.testing.config.LocalConfig.OBJECT_MAPPER;
import static com.awesome.testing.generator.EmailGenerator.getRandomEmailTo;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Email {

    public static final HttpRequestActionBuilder EMAIL_REQUEST = http("Post email request")
            .post("/email")
            .body(StringBody(Email::buildEmailBody))
            .check(status().is(200));

    @SneakyThrows
    private static String buildEmailBody(Session session) {
        EmailDto email = getRandomEmailTo(session.get("email"));
        return OBJECT_MAPPER.writeValueAsString(email);
    }
}
