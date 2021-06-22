package io.fabs.util;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.FileNotFoundException;
import java.util.Map;

public class TemplateRenderer {
    /**
     * Render a template
     */
    public static String render(String file, Map<String, String> context) throws FileNotFoundException {
        FileUtils utils = new FileUtils();
        Template tmpl = Mustache.compiler().compile(utils.getContent(file));
        return tmpl.execute(context);
    }

    /**
     * Transform a filename
     */
    public static String transformTemplateName(String templateString, Map<String, String> variables) {
        String[] parts = templateString.split("/");
        String fileName = parts[parts.length - 1];
        fileName = fileName.replace(".mustache", "");
        Template tmpl = Mustache.compiler().compile(fileName);
        return tmpl.execute(variables);
    }
}
