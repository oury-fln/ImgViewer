package com.example.imgviewer.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StringUtil {
    public static String join(String[] input, String split) {
        if (input.length == 0) return "";
        StringBuilder output = new StringBuilder(input[0]);
        for (int i=1; i < input.length; ++i) {
            output.append(split).append(input[i]);
        }
        return output.toString();
    }

    public static InputStream getStringStream(String sInputString) {
        if (sInputString != null && !sInputString.trim().equals("")) {
            try {
                return new ByteArrayInputStream(sInputString.getBytes());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
