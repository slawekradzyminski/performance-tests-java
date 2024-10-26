package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import java.time.Duration;

import static com.awesome.testing.feeder.UserFeeder.USER_FEEDER;
import static com.awesome.testing.http.Login.LOGIN_REQUEST;
import static com.awesome.testing.http.Register.REGISTER_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

public class TrainingScenario {

    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(USER_FEEDER)
            .exec(REGISTER_REQUEST)
            .pause(Duration.ofSeconds(5))
            .exec(LOGIN_REQUEST);

}
