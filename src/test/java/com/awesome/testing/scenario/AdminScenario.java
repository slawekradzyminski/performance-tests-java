package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

import static com.awesome.testing.http.PostProduct.CREATE_PRODUCT;
import static com.awesome.testing.http.PostUsersSignIn.LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.csv;
import static io.gatling.javaapi.core.CoreDsl.scenario;

@Slf4j
public class AdminScenario {

    public static ScenarioBuilder ADMIN_SCENARIO = scenario("Admin scenario")
            .feed(csv("data/gatling_admins.csv").circular())
            .exec(LOGIN_REQUEST)
            .pause(Duration.ofSeconds(2))
            .exec(CREATE_PRODUCT);

}
