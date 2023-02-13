package com.awesome.testing;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.util.List;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class BasicGetRequestSimulation extends Simulation {

    private static final String JSON = "application/json";

    private final HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://jsonplaceholder.typicode.com")
            .acceptHeader(JSON)
            .contentTypeHeader(JSON);

    ScenarioBuilder scn = scenario("Training scenario")
            .exec(http("Admin login request")
                    .post("/posts")
            );

    {
        setUp(scn.injectOpen(atOnceUsers(1)).protocols(httpProtocol))
                .assertions(
                        List.of(
                                global().responseTime().max().lt(3000),
                                global().successfulRequests().percent().is(100d)
                        )
                );
    }
}
