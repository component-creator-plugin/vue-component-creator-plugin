package fabs.util;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.util.Map;

public class TemplateRenderer {
    public String render(String file, Map<String, Object> context) {
        FileUtils utils = new FileUtils();
        Template tmpl = Mustache.compiler().compile(utils.getContent(file));
        return tmpl.execute(context);
    }
}
