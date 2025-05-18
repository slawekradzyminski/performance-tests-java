package com.awesome.testing;

import io.gatling.javaapi.core.Simulation;

import static com.awesome.testing.core.GlobalAssertions.ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.MAILHOG_HTTP_CONFIG;
import static com.awesome.testing.scenario.EmailVerificationScenario.EMAIL_VERIFICATION_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;

@SuppressWarnings("unused")
public class EmailVerificationSimulation extends Simulation {

    {
        setUp(
                EMAIL_VERIFICATION_SCENARIO.injectOpen(
                        atOnceUsers(1)
                )
        )
                .protocols(MAILHOG_HTTP_CONFIG)
                .assertions(ASSERTIONS);
    }
}
