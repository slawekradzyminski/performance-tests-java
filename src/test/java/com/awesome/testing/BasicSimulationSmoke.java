package com.awesome.testing;

import io.gatling.javaapi.core.PopulationBuilder;
import io.gatling.javaapi.core.Simulation;

import java.time.Duration;

import static com.awesome.testing.core.AssertionsConfig.HARD_ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.TrainingScenario.getTrainingScenario;
import static io.gatling.javaapi.core.CoreDsl.*;

/**
 * Load tests - the amount of traffic in test is configured here
 */
public class BasicSimulationSmoke extends Simulation {

    private static final int LOGIN_RPM = 60; // tą wartość bierzemy z produkcji / wymagań
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int LOGIN_RPS = LOGIN_RPM / SECONDS_IN_MINUTE;

    private static final PopulationBuilder LOAD_TEST_TRAFFIC = getTrainingScenario("Load").injectOpen(
            rampUsersPerSec(0).to(LOGIN_RPS).during(Duration.ofMinutes(2)),
            constantUsersPerSec(LOGIN_RPS).during(Duration.ofMinutes(5)).randomized(),
            rampUsersPerSec(LOGIN_RPS).to(0).during(Duration.ofMinutes(2))
    );

    private static final PopulationBuilder SPIKE_TRAFFIC = getTrainingScenario("Spike").injectOpen(
            nothingFor(Duration.ofMinutes(4)),
            atOnceUsers(100)
    );

    {
        setUp(LOAD_TEST_TRAFFIC, SPIKE_TRAFFIC)
                .protocols(HTTP_CONFIG)
                .assertions(HARD_ASSERTIONS);
    }
}
