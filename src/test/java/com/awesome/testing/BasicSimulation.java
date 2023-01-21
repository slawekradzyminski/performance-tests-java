package com.awesome.testing;

import io.gatling.javaapi.core.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.awesome.testing.core.FunctionalAssertions.ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.TrainingScenario.TRAINING_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

public class BasicSimulation extends Simulation {

    {
        setUp(TRAINING_SCENARIO.injectOpen(
                atOnceUsers(2)
//                rampUsers(200).during(Duration.of(60, ChronoUnit.SECONDS))
                )
                .protocols(HTTP_CONFIG))
                .assertions(ASSERTIONS);
    }
}
