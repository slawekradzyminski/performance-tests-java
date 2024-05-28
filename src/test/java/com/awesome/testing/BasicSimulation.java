package com.awesome.testing;

import io.gatling.javaapi.core.*;

import java.time.Duration;

import static com.awesome.testing.core.GlobalAssertions.GLOBAL_ASSERTIONS;
import static com.awesome.testing.config.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.LoginScenario.LOGIN_SCENARIO;
import static com.awesome.testing.scenario.TrainingScenario.TRAINING_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

public class BasicSimulation extends Simulation {

    private static final double LOGIN_RPS_IN_MAIN_SCENARIO = 0.5;
    private static final double LOGIN_RPS_IN_ADDITIONAL_SCENARIO = 1.5;

    {
        PopulationBuilder mainTrainingScenario = TRAINING_SCENARIO.injectOpen(
                rampUsersPerSec(0).to(LOGIN_RPS_IN_MAIN_SCENARIO).during(Duration.ofMinutes(1)),
                constantUsersPerSec(LOGIN_RPS_IN_MAIN_SCENARIO).during(Duration.ofMinutes(2)).randomized(),
                rampUsersPerSec(LOGIN_RPS_IN_MAIN_SCENARIO).to(0).during(Duration.ofMinutes(1))
        );

        PopulationBuilder loginScenario = LOGIN_SCENARIO.injectOpen(
                rampUsersPerSec(0).to(LOGIN_RPS_IN_ADDITIONAL_SCENARIO).during(Duration.ofMinutes(1)),
                constantUsersPerSec(LOGIN_RPS_IN_ADDITIONAL_SCENARIO).during(Duration.ofMinutes(2)).randomized(),
                rampUsersPerSec(LOGIN_RPS_IN_ADDITIONAL_SCENARIO).to(0).during(Duration.ofMinutes(1))
        );

        setUp(
                mainTrainingScenario, loginScenario
        )
                .protocols(HTTP_CONFIG)
                .assertions(GLOBAL_ASSERTIONS);
    }
}
