package com.awesome.testing.util;

import org.apache.commons.lang3.RandomStringUtils;

public class Random {

    public static String getRandomString() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    public static String getRandomEmail() {
        return getRandomString() + "@foo.com";
    }

}
