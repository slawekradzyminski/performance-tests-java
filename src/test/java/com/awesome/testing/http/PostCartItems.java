package com.awesome.testing.http;

import com.awesome.testing.dto.AddToCartRequestDto;
import io.gatling.javaapi.core.Session;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static com.awesome.testing.core.Jackson.getObjectMapper;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

@Slf4j
public class PostCartItems {

    public static final HttpRequestActionBuilder ADD_TO_BASKET =
            http("Add product to basket")
                    .post("/api/cart/items")
                    .header("Authorization", "Bearer #{token}")
                    .body(StringBody(PostCartItems::buildRequestBody))
                    .check(status().is(200));

    @SneakyThrows
    private static String buildRequestBody(Session session) {
        AddToCartRequestDto addToCartRequestDto = AddToCartRequestDto.builder()
                .quantity(1)
                .productId(session.getInt("productId"))
                .build();

        return getObjectMapper().writeValueAsString(addToCartRequestDto);
    }

}
