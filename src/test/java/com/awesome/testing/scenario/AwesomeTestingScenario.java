package com.awesome.testing.scenario;

import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;

import java.time.Duration;

import static com.awesome.testing.feeder.UserGenerator.USER_FEEDER;
import static com.awesome.testing.http.PostUsersSignIn.LOGIN_REQUEST;
import static com.awesome.testing.http.PostUsersSignUp.REGISTER_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

/**
 * Scenariusz piszemy jak test funkcjonalny, który odpowiada jednemu typowi użytkownika
 * Wszystko co jest wykonywane w ramach scenariusza to jedna Gatlingowa sesja
 */
public class AwesomeTestingScenario {

    public static ScenarioBuilder CUSTOMER_SCENARIO = scenario("Customer scenario")
            .feed(USER_FEEDER)
            .exec(REGISTER_REQUEST)
            .pause(Duration.ofSeconds(4))
            .exec(LOGIN_REQUEST);

}
