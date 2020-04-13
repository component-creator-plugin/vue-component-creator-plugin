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
