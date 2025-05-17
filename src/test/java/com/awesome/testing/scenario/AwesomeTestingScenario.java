package com.awesome.testing.scenario;

import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.http.PostUsersSignIn.LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

/**
 * Scenariusz piszemy jak test funkcjonalny, który odpowiada jednemu typowi użytkownika
 * Wszystko co jest wykonywane w ramach scenariusza to jedna Gatlingowa sesja
 */
public class AwesomeTestingScenario {

    public static final FeederBuilder.FileBased<Object> CREDENTIALS_FEEDER = jsonFile("data/credentials.json").circular();

    public static ScenarioBuilder CUSTOMER_SCENARIO = scenario("Training scenario")
            .feed(CREDENTIALS_FEEDER)
            .exec(LOGIN_REQUEST);

}
