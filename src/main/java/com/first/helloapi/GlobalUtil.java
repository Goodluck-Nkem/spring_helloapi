package com.first.helloapi;

/** This is a utility class, so All methods are expected to be public static, so that an instance is not required */
public class GlobalUtil {

    /** custom trim utility, returns null or trimmed string */
    public static String trim(String s) {
        return s != null ? s.trim() : null;
    }
}
