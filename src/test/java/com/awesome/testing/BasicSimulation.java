package com.awesome.testing;

import io.gatling.javaapi.core.*;

import static com.awesome.testing.core.GlobalAssertions.ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.TrainingScenario.TRAINING_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

public class BasicSimulation extends Simulation {

    {
        setUp(
                TRAINING_SCENARIO.injectOpen(atOnceUsers(10))
        )
                .protocols(HTTP_CONFIG)
                .assertions(ASSERTIONS);
    }
}
