package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.request.Login.ADMIN_LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.scenario;

/**
 * Represents a single user journey
 */
public class CleanupScenario {

    public static final ScenarioBuilder CLEANUP_SCENARIO = scenario("Training scenario")
            .exec(ADMIN_LOGIN_REQUEST);

}
