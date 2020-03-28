package fabs.util;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.util.Map;

public class TemplateRenderer {
    /**
     * Render a template
     * @param file
     * @param context
     * @return
     */
    public static String render(String file, Map<String, Object> context) {
        FileUtils utils = new FileUtils();
        Template tmpl = Mustache.compiler().compile(utils.getContent(file));
        return tmpl.execute(context);
    }

    /**
     * Transform a filename
     * @param templateString
     * @param componentName
     * @return
     */
    public static String transformTemplateName(String templateString, String componentName) {
        String[] parts = templateString.split("/");
        String fileName = parts[parts.length - 1];
        return fileName
                .replace(".mustache", "")
                .replace("component", componentName)
                ;
    }
}
