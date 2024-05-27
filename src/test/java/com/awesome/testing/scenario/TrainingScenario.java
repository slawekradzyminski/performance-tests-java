package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.request.Login.LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class TrainingScenario {


    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .exec(LOGIN_REQUEST);

}
