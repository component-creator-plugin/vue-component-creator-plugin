package fabs.util;

import static fabs.util.FileUtil.COMPONENT_NAME_TOKEN;

public class TokenReplacer {
    public static String replace(String content, String componentName) {
        return content.replaceAll(COMPONENT_NAME_TOKEN, componentName);
    }
}
