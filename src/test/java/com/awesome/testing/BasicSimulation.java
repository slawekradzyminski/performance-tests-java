package com.awesome.testing;

import io.gatling.javaapi.core.*;

import java.time.Duration;

import static com.awesome.testing.core.GlobalAssertions.GLOBAL_ASSERTIONS;
import static com.awesome.testing.config.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.TrainingScenario.TRAINING_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

public class BasicSimulation extends Simulation {

    private static final double DESIRED_RPM = 30;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final double RPS = DESIRED_RPM / SECONDS_IN_MINUTE;

    {
        setUp(TRAINING_SCENARIO.injectOpen(
                        rampUsersPerSec(0).to(RPS).during(Duration.ofMinutes(1)),
                        constantUsersPerSec(RPS).during(Duration.ofMinutes(2)).randomized(),
                        rampUsersPerSec(RPS).to(0).during(Duration.ofMinutes(1))
                )
                .protocols(HTTP_CONFIG))
                .assertions(GLOBAL_ASSERTIONS);
    }
}
