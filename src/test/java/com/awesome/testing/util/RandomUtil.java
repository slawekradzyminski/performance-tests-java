package com.awesome.testing.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtil {

    public static String randomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

}
