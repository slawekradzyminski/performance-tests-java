package com.awesome.testing;

import io.gatling.javaapi.core.Simulation;

import static com.awesome.testing.core.AssertionsConfig.HARD_ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.CleanupScenario.CLEANUP_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;

/**
 * Load tests - the amount of traffic in test is configured here
 */
public class CleanupSimulation extends Simulation {

    {
        setUp(CLEANUP_SCENARIO.injectOpen(
                atOnceUsers(1)
        ).protocols(HTTP_CONFIG))
                .assertions(HARD_ASSERTIONS);
    }
}
