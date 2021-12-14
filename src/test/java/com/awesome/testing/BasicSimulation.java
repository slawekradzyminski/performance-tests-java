package com.awesome.testing;

import java.time.Duration;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class BasicSimulation extends Simulation {

    private static final String json = "application/json";

    private final HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:4000")
            .acceptHeader(json)
            .contentTypeHeader(json);

    ScenarioBuilder scn = scenario("Training scenarion")
            .exec(http("Admin login request")
                    .post("/users/signin")
                    .body(ElFileBody("bodies/adminLogin.json"))
                    .check(status().is(200))
            );

    {
        setUp(scn.injectOpen(atOnceUsers(1)).protocols(httpProtocol));
    }
}
