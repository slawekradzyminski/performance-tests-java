package com.awesome.testing.http;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import java.util.List;
import java.util.function.Function;

import static com.awesome.testing.util.ListUtil.listLengthIsBiggerThan;
import static io.gatling.javaapi.core.CoreDsl.ElFileBody;
import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class GetUsers {

    public static final HttpRequestActionBuilder GET_ALL_USERS_REQUEST =
            http("Get all users request")
                    .get("/users")
                    .header("Authorization", "Bearer " + "#{token}")
                    .check(status().is(200))
                    .check(jsonPath("$").ofList().transform(listLengthIsBiggerThan(1)).is(true));

}
