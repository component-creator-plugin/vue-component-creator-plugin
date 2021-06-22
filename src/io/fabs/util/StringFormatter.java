package io.fabs.util;
import com.google.common.base.CaseFormat;


public class StringFormatter {
    public static String toCamelCase(String input) {
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, input);
    }

    public static String toPascalCase(String input) {
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, input);
    }

    public static String toDashCase(String input) {
        StringBuffer sb = new StringBuffer();
        int c = 0;
        for (String s : input.split("-")) {
            if (c != 0) {
                sb.append("_");
            }

            sb.append(Character.toLowerCase(s.charAt(0)));
            if (s.length() > 1) {
                sb.append(s.substring(1, s.length()).toLowerCase());
            }
            c++;
        }
        return sb.toString();
    }

    public static String capitalizeFirst(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
