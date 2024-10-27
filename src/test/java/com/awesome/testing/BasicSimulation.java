package com.awesome.testing;

import io.gatling.javaapi.core.*;

import java.time.Duration;

import static com.awesome.testing.core.GlobalAssertions.ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.TrainingScenario.TRAINING_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

public class BasicSimulation extends Simulation {

    private static final int DESIRED_RPM = 60;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final double RPS = (double) DESIRED_RPM / SECONDS_IN_MINUTE;

    {
        setUp(
                TRAINING_SCENARIO.injectOpen(
                        rampUsersPerSec(0).to(RPS).during(Duration.ofMinutes(5)), // ramp up
                        constantUsersPerSec(RPS).during(Duration.ofMinutes(10)), // peak traffic (main test)
                        rampUsersPerSec(RPS).to(0).during(Duration.ofMinutes(5)) // ramp down
                )
        )
                .protocols(HTTP_CONFIG)
                .assertions(ASSERTIONS);
    }
}
