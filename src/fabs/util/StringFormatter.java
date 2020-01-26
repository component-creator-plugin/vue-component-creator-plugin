package fabs.util;

public class StringFormatter {
    public static String toSnakeCase(String name) {
        StringBuffer buffer = new StringBuffer();

        String[] tokens = name.split("-");
        for (String token : tokens) {
            buffer.append(token.substring(0, 1).toUpperCase() + token.substring(1));
        }

        return buffer.toString();
    }
}
