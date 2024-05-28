package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import java.time.Duration;

import static com.awesome.testing.request.Register.REGISTER_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.csv;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class UserRegisterScenario {

    public static final ScenarioBuilder USER_REGISTER_SCENARIO = scenario("User register scenario")
            .feed(csv("data/UsersCredentials.csv").queue())
            .pause(Duration.ofSeconds(0), Duration.ofMinutes(10))
            .exec(REGISTER_REQUEST);

}
