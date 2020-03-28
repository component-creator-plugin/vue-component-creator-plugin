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

    /**
     * Transform a string from dash case to camel case
     * @param input
     * @return
     */
    public static String toCamelCase(String input) {
        StringBuffer sb = new StringBuffer();
        for (String s : input.split("-")) {
            sb.append(Character.toUpperCase(s.charAt(0)));
            if (s.length() > 1) {
                sb.append(s.substring(1, s.length()).toLowerCase());
            }
        }
        return sb.toString();

    }
}
