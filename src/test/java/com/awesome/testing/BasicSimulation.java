package com.awesome.testing;

import io.gatling.javaapi.core.*;

import java.time.Duration;

import static com.awesome.testing.core.FunctionalAssertions.ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.TrainingScenario.TRAINING_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

public class BasicSimulation extends Simulation {

    private static final int SECONDS_IN_MINUTE = 60;

    private static final int RPM = 60;
    private static final int RPS = RPM / SECONDS_IN_MINUTE;

    private static final Duration RAMP_UP_TIME = Duration.ofMinutes(2);
    private static final Duration SIMULATION_TIME = Duration.ofMinutes(5);
    private static final Duration RAMP_DOWN_TIME = Duration.ofMinutes(1);

    {
        setUp(TRAINING_SCENARIO.injectOpen(
                        atOnceUsers(1)
                )
                .protocols(HTTP_CONFIG))
                .assertions(ASSERTIONS);
    }
}
