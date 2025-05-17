package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.http.PostUsersSignIn.LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.scenario;

/**
 * Scenariusz piszemy jak test funkcjonalny, który odpowiada jednemu typowi użytkownika
 */
public class AwesomeTestingScenario {

    public static ScenarioBuilder CUSTOMER_SCENARIO = scenario("Training scenario")
            .exec(LOGIN_REQUEST);

}
