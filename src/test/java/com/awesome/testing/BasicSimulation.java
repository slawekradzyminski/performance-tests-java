package com.awesome.testing;

import io.gatling.javaapi.core.*;
import java.time.Duration;
import static com.awesome.testing.core.GlobalAssertions.GLOBAL_ASSERTIONS;
import static com.awesome.testing.config.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.TrainingScenario.TRAINING_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

/**
 * We assume that each of our endpoints has 60rpm and we are writing a regression test to check that
 * we are still able to handle this type of traffic properly
 */
public class BasicSimulation extends Simulation {

    private static final double INITIAL_RPS = 0.5;
    private static final double RPS_INCREMENT = 0.5;
    private static final int STAGES = 2;

    {
        setUp(TRAINING_SCENARIO.injectOpen(getSteps()).protocols(HTTP_CONFIG))
                .assertions(GLOBAL_ASSERTIONS);
    }

    private static OpenInjectionStep[] getSteps() {
        OpenInjectionStep[] steps = new OpenInjectionStep[STAGES * 2];
        for (int i = 0; i < STAGES; i++) {
            double startRps = INITIAL_RPS + RPS_INCREMENT * i;
            double endRps = startRps + RPS_INCREMENT;
            steps[2 * i] = rampUsersPerSec(startRps).to(endRps).during(Duration.ofSeconds(30));
            steps[2 * i + 1] = constantUsersPerSec(endRps).during(Duration.ofSeconds(30));
        }
        return steps;
    }
}
