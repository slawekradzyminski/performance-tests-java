package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;

import static com.awesome.testing.request.DeleteUser.deleteUser;
import static com.awesome.testing.request.GetUsers.GET_ALL_USERS_AS_ADMIN_REQUEST;
import static com.awesome.testing.request.Login.ADMIN_LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.*;

public class CleanupScenario {

    public static final ScenarioBuilder CLEANUP_SCENARIO = scenario("Cleanup scenario")
            .exec(ADMIN_LOGIN_REQUEST)
            .pause(5)
            .exec(GET_ALL_USERS_AS_ADMIN_REQUEST)
            .pause(5)
            .foreach("#{usernames}", "username").on(
                    doIf(session -> !session.get("username").equals("admin"))
                            .then(
                                    exec(deleteUser("#{username}"))
                            )
            );


}
