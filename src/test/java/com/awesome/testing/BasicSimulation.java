package com.awesome.testing;

import io.gatling.javaapi.core.*;

import static com.awesome.testing.core.AssertionsConfig.HARD_ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.TrainingScenario.TRAINING_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

/**
 * Load tests - the amount of traffic in test is configured here
 */
public class BasicSimulation extends Simulation {

    {
        setUp(TRAINING_SCENARIO.injectOpen(
                atOnceUsers(3)
        ).protocols(HTTP_CONFIG))
                .assertions(HARD_ASSERTIONS);
    }
}
