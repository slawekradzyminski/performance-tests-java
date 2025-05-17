package com.awesome.testing.feeder;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import static com.awesome.testing.feeder.FakerHelper.FAKER;

public class QrTextGenerator {

    private static Map<String, Object> generateQrData() {
        return Map.of(
                "qrText",
                FAKER.internet().url()
        );
    }

    public static final Iterator<Map<String, Object>> QR_FEEDER =
            Stream.generate(QrTextGenerator::generateQrData).iterator();
}
