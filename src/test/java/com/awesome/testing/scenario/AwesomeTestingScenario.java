package com.awesome.testing.scenario;

import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;

import java.time.Duration;

import static com.awesome.testing.feeder.QrTextGenerator.QR_FEEDER;
import static com.awesome.testing.feeder.UserGenerator.USER_FEEDER;
import static com.awesome.testing.http.GetMe.GET_ME;
import static com.awesome.testing.http.GetProducts.GET_PRODUCTS;
import static com.awesome.testing.http.PostCartItems.ADD_TO_BASKET;
import static com.awesome.testing.http.PostQrCreate.CREATE_QR_CODE;
import static com.awesome.testing.http.PostUsersSignIn.LOGIN_REQUEST;
import static com.awesome.testing.http.PostUsersSignUp.REGISTER_REQUEST;
import static com.awesome.testing.http.PutUserEdit.EDIT_USER;
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
            .exec(LOGIN_REQUEST)
            .pause(Duration.ofSeconds(1))
            .exec(GET_ME)
            .pause(Duration.ofSeconds(1))
            .exec(GET_PRODUCTS)
            .pause(Duration.ofSeconds(2))
            .exec(ADD_TO_BASKET)
            .pause(Duration.ofSeconds(2))
            .exec(EDIT_USER)
            .pause(Duration.ofSeconds(1))
            .feed(QR_FEEDER)
            .exec(CREATE_QR_CODE);
}
