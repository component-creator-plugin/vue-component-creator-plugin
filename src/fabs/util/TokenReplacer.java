package fabs.util;

import static fabs.util.FileUtil.COMPONENT_NAME_TOKEN;
import static fabs.util.FileUtil.MUTATION_TYPE_FILE_PATH_TOKEN;
import static fabs.util.FileUtil.MUTATION_NAME_TOKEN;

public class TokenReplacer {
    public static String replace(String content, String componentName, String mutationTypeFilePath, String mutationName) {
        return content.replaceAll(COMPONENT_NAME_TOKEN, componentName)
                .replaceAll(MUTATION_TYPE_FILE_PATH_TOKEN, mutationTypeFilePath)
                .replaceAll(MUTATION_NAME_TOKEN, mutationName)
                ;
    }
}
