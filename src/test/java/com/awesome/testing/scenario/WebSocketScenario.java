package com.awesome.testing.scenario;

import io.gatling.javaapi.core.ScenarioBuilder;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

import static com.awesome.testing.http.PostUsersSignIn.LOGIN_REQUEST;
import static io.gatling.javaapi.core.CoreDsl.csv;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.ws;

@Slf4j
public class WebSocketScenario {

    public static ScenarioBuilder WEB_SOCKET_SCENARIO = scenario("WebSocket Traffic Monitor Test")
            .feed(csv("data/gatling_admins.csv").circular())
            .exec(LOGIN_REQUEST)
            .pause(Duration.ofMillis(500))
            .exec(ws("Open WebSocket").connect("/ws-traffic")) // Step 3.2
//            .pause(Duration.ofMillis(500))
            .exec(ws("STOMP Connect").sendText(session -> {
                String token = session.getString("token");
                return "CONNECT\nAuthorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnYXRsaW5nX2FkbWluMjUiLCJhdXRoIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE3NDc1NzE2NTIsImV4cCI6MTc0NzU3NTI1Mn0.fclmoCRlIOrcBGr13p2MvOWLxTsOUNkc8QXPiZUNn3s\naccept-version:1.2,1.1,1.0\nheart-beat:10000,10000\n\n\u0000"
;
            }));

}
