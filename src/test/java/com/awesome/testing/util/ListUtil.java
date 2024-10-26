package com.awesome.testing.util;

import java.util.List;
import java.util.function.Function;

public class ListUtil {

    public static Function<List<Object>, Boolean> listLengthIsBiggerThan(int length) {
        return list -> list.size() > length;
    }


}
