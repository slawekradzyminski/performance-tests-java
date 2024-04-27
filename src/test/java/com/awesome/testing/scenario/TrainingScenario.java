package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.feeder.CredentialsFeeder.CREDENTIALS_FEEDER;
import static com.awesome.testing.request.Login.LOGIN_REQUEST;
import static com.awesome.testing.request.Register.REGISTER_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class TrainingScenario {

    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(CREDENTIALS_FEEDER)
            .exec(REGISTER_REQUEST)
            .pause(10)
            .exec(LOGIN_REQUEST);

}
