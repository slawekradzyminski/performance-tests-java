package com.awesome.testing.http;

import com.awesome.testing.dto.CreateProductDto;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.SneakyThrows;

import static com.awesome.testing.core.Jackson.getObjectMapper;
import static com.awesome.testing.feeder.FakerHelper.FAKER;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.http.HttpDsl.*;

public class PostProduct {

    public static final HttpRequestActionBuilder CREATE_PRODUCT =
            http("Create product")
                    .post("/api/products")
                    .header("Authorization", "Bearer #{token}")
                    .body(StringBody(body()))
                    .check(status().is(201));

    @SneakyThrows
    private static String body() {
        CreateProductDto dto = CreateProductDto.builder()
                .name(FAKER.commerce().productName())
                .price(Double.parseDouble(FAKER.commerce().price()))
                .stockQuantity(FAKER.number().positive())
                .category(FAKER.commerce().department())
                .imageUrl(FAKER.internet().url() + ".png")
                .build();

        return getObjectMapper().writeValueAsString(dto);
    }
}
