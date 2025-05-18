package com.awesome.testing.http;

import com.awesome.testing.dto.EmailRequestDto;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.SneakyThrows;

import static com.awesome.testing.core.Jackson.getObjectMapper;
import static com.awesome.testing.feeder.FakerHelper.FAKER;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.http.HttpDsl.*;

public class PostEmail {

    public static HttpRequestActionBuilder sendEmail(String prefix) {
        return http("Send email")
                .post("/email")
                .header("Authorization", "Bearer #{token}")
                .body(StringBody(body(prefix)))
                .check(status().is(200));
    }

    @SneakyThrows
    private static String body(String prefix) {
        EmailRequestDto dto = EmailRequestDto.builder()
                .to(FAKER.internet().emailAddress())
                .subject(buildSubject(prefix))
                .message(FAKER.lorem().paragraph())
                .build();
        return getObjectMapper().writeValueAsString(dto);
    }

    private static String buildSubject(String prefix) {
        return String.format("%s %s", prefix, FAKER.lorem().sentence());
    }
}
