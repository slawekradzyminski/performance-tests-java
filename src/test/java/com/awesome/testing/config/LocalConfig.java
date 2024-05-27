package com.awesome.testing.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocalConfig {

    public static final String BASE_URL = "http://localhost:4001";

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

}
