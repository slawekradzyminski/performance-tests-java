package com.awesome.testing.scenario;

import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.http.PostUsersSignIn.LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.csv;
import static io.gatling.javaapi.core.CoreDsl.scenario;

/**
 * Scenariusz piszemy jak test funkcjonalny, który odpowiada jednemu typowi użytkownika
 * Wszystko co jest wykonywane w ramach scenariusza to jedna Gatlingowa sesja
 */
public class AwesomeTestingScenario {

    public static final FeederBuilder.Batchable<String> CREDENTIALS_FEEDER = csv("data/credentials.csv").circular();

    public static ScenarioBuilder CUSTOMER_SCENARIO = scenario("Training scenario")
            .feed(CREDENTIALS_FEEDER)
            .exec(LOGIN_REQUEST);

}
