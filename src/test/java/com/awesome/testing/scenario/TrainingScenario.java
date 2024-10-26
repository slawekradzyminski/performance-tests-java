package com.awesome.testing.scenario;

import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.http.Login.LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.csv;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class TrainingScenario {

    private static final FeederBuilder.Batchable<String> CREDENTIALS = csv("data/credentials.csv").circular();

    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(CREDENTIALS)
            .exec(LOGIN_REQUEST);

}
