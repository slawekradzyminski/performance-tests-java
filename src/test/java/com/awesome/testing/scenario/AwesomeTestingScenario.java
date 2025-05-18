package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import java.time.Duration;

import static com.awesome.testing.feeder.UserGenerator.USER_FEEDER;
import static com.awesome.testing.http.GetCart.GET_CART;
import static com.awesome.testing.http.GetMe.GET_ME;
import static com.awesome.testing.http.GetProducts.GET_PRODUCTS;
import static com.awesome.testing.http.GetUsers.GET_USERS;
import static com.awesome.testing.http.PostCartItems.ADD_TO_BASKET;
import static com.awesome.testing.http.PostQrCreate.CREATE_QR_CODE;
import static com.awesome.testing.http.PostUsersSignIn.LOGIN_REQUEST;
import static com.awesome.testing.http.PostUsersSignUp.REGISTER_REQUEST;
import static com.awesome.testing.http.PutUserEdit.EDIT_USER;
import static com.awesome.testing.util.RpsHelper.repeatWithFraction;
import static io.gatling.javaapi.core.CoreDsl.*;

/**
 * Scenariusz piszemy jak test funkcjonalny, który odpowiada jednemu typowi użytkownika
 * Wszystko co jest wykonywane w ramach scenariusza to jedna Gatlingowa sesja
 */
public class AwesomeTestingScenario {

    public static ScenarioBuilder CUSTOMER_SCENARIO = scenario("Customer scenario")
            .feed(USER_FEEDER)
            .exec(REGISTER_REQUEST) // też 1 rps
            .pause(Duration.ofSeconds(4))
            .exec(LOGIN_REQUEST) // 1 rps - request referencyjny
            .exitHereIfFailed()
            .exec(repeatWithFraction(4, pause(Duration.ofSeconds(1)).exec(GET_ME)))
            .exec(repeatWithFraction(2, exec(GET_CART)))
            .exec(repeatWithFraction(0.75, pause(Duration.ofSeconds(2)).exec(GET_USERS)))
            .exec(repeatWithFraction(4, pause(Duration.ofSeconds(1)).exec(GET_PRODUCTS)))
            .exec(repeatWithFraction(2.5, pause(Duration.ofSeconds(2)).exec(ADD_TO_BASKET)))
            .exec(repeatWithFraction(0.25, pause(Duration.ofSeconds(2)).exec(EDIT_USER)))
            .exec(repeatWithFraction(0.5, pause(Duration.ofSeconds(1)).exec(CREATE_QR_CODE)));

}
