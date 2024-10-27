package com.awesome.testing;

import io.gatling.javaapi.core.*;

import java.time.Duration;

import static com.awesome.testing.core.GlobalAssertions.ASSERTIONS;
import static com.awesome.testing.core.HttpConfig.HTTP_CONFIG;
import static com.awesome.testing.scenario.LoginScenario.LOGIN_SCENARIO;
import static com.awesome.testing.scenario.RegisterScenario.REGISTER_SCENARIO;
import static io.gatling.javaapi.core.CoreDsl.*;

@SuppressWarnings("unused")
public class BasicSimulation extends Simulation {

    private static final int DESIRED_RPM = 60;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final double RPS = (double) DESIRED_RPM / SECONDS_IN_MINUTE;
    private static final double REGISTER_RPS = RPS / 2;

    {
        setUp(
                loggedInUsersTraffic(),
                registerTraffic()
        )
                .protocols(HTTP_CONFIG)
                .assertions(ASSERTIONS);
    }

    private static PopulationBuilder loggedInUsersTraffic() {
        return LOGIN_SCENARIO.injectOpen(
                rampUsersPerSec(0).to(RPS).during(Duration.ofMinutes(5)),
                constantUsersPerSec(RPS).during(Duration.ofMinutes(10)),
                rampUsersPerSec(RPS).to(0).during(Duration.ofMinutes(5))
        );
    }

    private static PopulationBuilder registerTraffic() {
        return REGISTER_SCENARIO.injectOpen(
                rampUsersPerSec(0).to(REGISTER_RPS).during(Duration.ofMinutes(5)),
                constantUsersPerSec(REGISTER_RPS).during(Duration.ofMinutes(10)),
                rampUsersPerSec(REGISTER_RPS).to(0).during(Duration.ofMinutes(5))
        );
    }
}
