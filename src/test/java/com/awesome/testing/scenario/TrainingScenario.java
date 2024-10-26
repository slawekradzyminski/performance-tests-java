package com.awesome.testing.scenario;

import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.http.Login.LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

public class TrainingScenario {

    private static final FeederBuilder.FileBased<Object> CREDENTIALS_FEEDER = jsonFile("data/users.json").circular();

    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(CREDENTIALS_FEEDER)
            .exec(LOGIN_REQUEST);

}
