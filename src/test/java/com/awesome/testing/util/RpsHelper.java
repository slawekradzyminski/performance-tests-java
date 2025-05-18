package com.awesome.testing.util;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.CoreDsl.percent;

public class RpsHelper {

    public static ChainBuilder repeatWithFraction(double count, ChainBuilder action) {
        int fullRepeats = (int) count;
        double fractionalPart = count - fullRepeats;

        ChainBuilder chain = exec(session -> session); // no-op base chain

        if (fullRepeats > 0) {
            chain = chain.exec(repeat(fullRepeats).on(action));
        }

        if (fractionalPart > 0) {
            chain = chain.exec(
                    randomSwitch().on(
                            percent(fractionalPart * 100).then(action)
                    )
            );
        }

        return chain;
    }

}
