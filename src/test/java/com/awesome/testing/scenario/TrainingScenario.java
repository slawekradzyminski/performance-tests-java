package com.awesome.testing.scenario;

import io.gatling.javaapi.core.FeederBuilder.FileBased;
import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.request.Login.LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

public class TrainingScenario {

    public static final FileBased<Object> CREDENTIALS_FEEDER = jsonFile("data/users.json").circular();

    public static final ScenarioBuilder TRAINING_SCENARIO = scenario("Training scenario")
            .feed(CREDENTIALS_FEEDER)
            .exec(LOGIN_REQUEST);

}
