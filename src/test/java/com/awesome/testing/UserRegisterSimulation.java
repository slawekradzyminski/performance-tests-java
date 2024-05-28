package com.awesome.testing;

import io.gatling.javaapi.core.Simulation;

import static com.awesome.testing.config.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.core.GlobalAssertions.GLOBAL_ASSERTIONS;
import static com.awesome.testing.scenario.UserRegisterScenario.USER_REGISTER_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;

public class UserRegisterSimulation extends Simulation {

    {
        setUp(USER_REGISTER_SCENARIO.injectOpen(
                        atOnceUsers(2000)
                )
                .protocols(HTTP_CONFIG))
                .assertions(GLOBAL_ASSERTIONS);
    }
}
