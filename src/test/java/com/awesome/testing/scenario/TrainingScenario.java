package com.awesome.testing.scenario;

import io.gatling.javaapi.core.FeederBuilder.Batchable;
import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.request.Login.LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.csv;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class TrainingScenario {

    private static final Batchable<String> CREDENTIALS_FEEDER = csv("data/credential.csv").circular();

    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(CREDENTIALS_FEEDER)
            .exec(LOGIN_REQUEST);

}
