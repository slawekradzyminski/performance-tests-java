package com.awesome.testing;

import io.gatling.javaapi.core.*;

import java.time.Duration;

import static com.awesome.testing.core.AssertionsConfig.HARD_ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.TrainingScenario.TRAINING_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.rampUsersPerSec;

/**
 * Load tests - the amount of traffic in test is configured here
 */
public class BasicSimulation extends Simulation {

    private static final int LOGIN_RPM = 120; // tą wartość bierzemy z produkcji / wymagań
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int LOGIN_RPS = LOGIN_RPM / SECONDS_IN_MINUTE;

    {
        setUp(
                TRAINING_SCENARIO.injectOpen(
                                // 1 ramp up (rozgrzanie JVM, wyskalowanie w górę)
                                rampUsersPerSec(0).to(LOGIN_RPS).during(Duration.ofMinutes(2)),
                                // 2 peak traffic (czy spełniamy wymagania, na tyle długi żeby w czasie trwania testu poszedł przynajmniej jeden Garbage Collector)
                                constantUsersPerSec(LOGIN_RPS).during(Duration.ofMinutes(5)).randomized(),
                                // 3 ramp down (wyskalowanie w dół)
                                rampUsersPerSec(LOGIN_RPS).to(0).during(Duration.ofMinutes(2))
                        )
                        .protocols(HTTP_CONFIG))
                .assertions(HARD_ASSERTIONS);
    }
}
