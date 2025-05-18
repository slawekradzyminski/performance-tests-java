package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import static com.awesome.testing.http.PostUsersSignUp.REGISTER_ADMIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.csv;
import static io.gatling.javaapi.core.CoreDsl.scenario;

@Slf4j
public class UserRegisterScenario {

    public static ScenarioBuilder USER_REGISTER_SCENARIO = scenario("User register scenario")
            .feed(csv("data/gatling_admins.csv").queue() )
            .pause(Duration.ofSeconds(getRandomDuration()))
            .exec(REGISTER_ADMIN_REQUEST);

    private static long getRandomDuration() {
        return ThreadLocalRandom.current().nextLong(0, 51); // Upper bound is exclusive
    }

}
