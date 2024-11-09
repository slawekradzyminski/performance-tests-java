package com.awesome.testing;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class CISimulation extends Simulation {

    private final HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://test-api.k6.io");

    ScenarioBuilder scn = scenario("Basic request scenario")
            .exec(http("Homepage request")
                    .get("/")
                    .check(status().is(200))
            )
            .pause(1);

    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        )
                .protocols(httpProtocol)
                .assertions(
                        List.of(
                                global().responseTime().max().lt(5000),
                                global().successfulRequests().percent().is(100d)
                        )
                );
    }
}
