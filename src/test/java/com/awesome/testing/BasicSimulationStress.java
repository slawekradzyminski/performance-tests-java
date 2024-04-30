package com.awesome.testing;

import io.gatling.javaapi.core.Simulation;

import java.time.Duration;

import static com.awesome.testing.core.AssertionsConfig.HARD_ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.TrainingScenario.getTrainingScenario;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.rampUsersPerSec;

/**
 * Load tests - the amount of traffic in test is configured here
 */
public class BasicSimulationStress extends Simulation {

    {
        setUp(
                getTrainingScenario("Load").injectOpen(
                                rampUsersPerSec(0).to(1).during(Duration.ofMinutes(1)),
                                constantUsersPerSec(1).during(Duration.ofMinutes(1)).randomized(),
                                rampUsersPerSec(1).to(2).during(Duration.ofMinutes(1)),
                                constantUsersPerSec(2).during(Duration.ofMinutes(1)).randomized(),
                                rampUsersPerSec(2).to(3).during(Duration.ofMinutes(1)),
                                constantUsersPerSec(3).during(Duration.ofMinutes(1)).randomized(),
                                rampUsersPerSec(3).to(4).during(Duration.ofMinutes(1)),
                                constantUsersPerSec(4).during(Duration.ofMinutes(1)).randomized(),
                                rampUsersPerSec(4).to(5).during(Duration.ofMinutes(1)),
                                constantUsersPerSec(5).during(Duration.ofMinutes(1)).randomized(),
                                rampUsersPerSec(5).to(0).during(Duration.ofMinutes(1))
                        )
                        .protocols(HTTP_CONFIG))
                .assertions(HARD_ASSERTIONS);
    }
}
