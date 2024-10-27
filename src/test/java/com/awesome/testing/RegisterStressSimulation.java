package com.awesome.testing;

import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.core.Simulation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.RegisterScenario.REGISTER_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.rampUsersPerSec;

@SuppressWarnings("unused")
public class RegisterStressSimulation extends Simulation {

    private static final int STARTING_RPS = 1;
    private static final int ENDING_RPS = 10;

    {
        List<OpenInjectionStep> injectionSteps = new ArrayList<>();

        for (int i = STARTING_RPS; i <= ENDING_RPS; i++) {
            injectionSteps.add(rampUsersPerSec(i - 1).to(i).during(Duration.ofSeconds(30)));
            injectionSteps.add(constantUsersPerSec(i).during(Duration.ofSeconds(30)));
        }

        setUp(
                REGISTER_SCENARIO.injectOpen(injectionSteps)
        )
                .protocols(HTTP_CONFIG)
                .assertions(List.of());
    }

}
