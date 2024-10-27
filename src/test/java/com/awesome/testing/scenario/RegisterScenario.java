package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import java.time.Duration;

import static com.awesome.testing.http.Register.REGISTER_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

public class RegisterScenario {

    public static final ScenarioBuilder REGISTER_SCENARIO = scenario("Training scenario")
            .feed(csv("data/fake_users.csv").queue())
            .pause(Duration.ofSeconds(1), Duration.ofMinutes(10))
            .exec(REGISTER_REQUEST);

}
