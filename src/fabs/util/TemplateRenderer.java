package fabs.util;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.FileNotFoundException;
import java.util.Map;

public class TemplateRenderer {
    /**
     * Render a template
     */
    public static String render(String file, Map<String, Object> context) throws FileNotFoundException {
        FileUtils utils = new FileUtils();
        Template tmpl = Mustache.compiler().compile(utils.getContent(file));
        return tmpl.execute(context);
    }

    /**
     * Transform a filename
     */
    public static String transformTemplateName(String templateString, Map<String, Object> variables) {
        String[] parts = templateString.split("/");
        String fileName = parts[parts.length - 1];

        Object[] keys = variables.keySet().toArray();
        fileName = fileName.replace(".mustache", "");

        for (Object key : keys) {
            fileName = fileName.replace("{{" + key.toString() + "}}", variables.get(key).toString());
        }
        return fileName;
    }
}
