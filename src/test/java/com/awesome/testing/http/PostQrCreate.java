package com.awesome.testing.http;

import com.awesome.testing.dto.CreateQrDto;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.SneakyThrows;

import static com.awesome.testing.core.Jackson.getObjectMapper;
import static com.awesome.testing.feeder.FakerHelper.FAKER;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.http.HttpDsl.status;

public class PostQrCreate {

    public static final HttpRequestActionBuilder CREATE_QR_CODE =
            http("Create QR code")
                    .post("/qr/create")
                    .header("Authorization", "Bearer #{token}")
                    .header("Accept", "image/png")
                    .body(StringBody(body()))
                    .check(
                            status().is(200),
                            header("Content-Type").is("image/png;charset=UTF-8")
                    );

    @SneakyThrows
    private static String body() {
        CreateQrDto dto = CreateQrDto.builder()
                .text(FAKER.lorem().sentence())
                .build();
        return getObjectMapper().writeValueAsString(dto);
    }
}
