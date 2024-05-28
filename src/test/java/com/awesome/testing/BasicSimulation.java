package com.awesome.testing;

import io.gatling.javaapi.core.*;

import java.time.Duration;

import static com.awesome.testing.core.GlobalAssertions.GLOBAL_ASSERTIONS;
import static com.awesome.testing.config.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.TrainingScenario.TRAINING_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

/**
 * Zakładamy że każdy nasz endpoint ma 60rpm i piszemy test regresyjny żeby sprawdzić że wciąż jesteśmy w stanie dobrze
 * obsłużyć tego typu ruch
 */
public class BasicSimulation extends Simulation {

    private static final int DESIRED_RPM = 60;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int RPS = DESIRED_RPM / SECONDS_IN_MINUTE;

    {
        setUp(TRAINING_SCENARIO.injectOpen(
                        rampUsersPerSec(0).to(RPS).during(Duration.ofMinutes(2)),
                        constantUsersPerSec(RPS).during(Duration.ofMinutes(4)).randomized(),
                        rampUsersPerSec(RPS).to(0).during(Duration.ofMinutes(2))
                )
                .protocols(HTTP_CONFIG))
                .assertions(GLOBAL_ASSERTIONS);
    }
}
