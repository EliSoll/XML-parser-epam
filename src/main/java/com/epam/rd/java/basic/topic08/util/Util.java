package com.epam.rd.java.basic.topic08.util;

import java.math.BigInteger;

/**
 * Utilities.
 *
 */
public class Util {
    public static BigInteger valueOfBigInt(String value) {
        return BigInteger.valueOf(Long.valueOf(value));
    }
}
