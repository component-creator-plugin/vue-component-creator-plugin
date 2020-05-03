package fabs.vue.component.data;

import fabs.util.AbstractOptions;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComponentCreateOptions extends AbstractOptions {
    public static final String STORE_KEY = "vcc.component";
    public static final String COMPONENT_TEMPLATE_KEY = "COMPONENT_TEMPLATE_KEY";
    public static final String SASS_TEMPLATE_KEY = "SASS_TEMPLATE_KEY";

    private final String defaultComponentTemplateFile = "templates/component/{{componentName}}.vue.mustache";
    private final String defaultSassTemplateFile = "templates/component/_{{componentName}}.scss.mustache";

    private String componentTemplateFile = defaultComponentTemplateFile;
    private String sassTemplateFile = defaultSassTemplateFile;

    private String componentName;

    @Override
    public ArrayList<String> getFiles() {
        ArrayList<String> files = new ArrayList<>();
        files.add(componentTemplateFile);
        files.add(sassTemplateFile);
        return files;
    }

    @Override
    public Map<String, Object> getTemplateVariables() {
        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("componentName", componentName);
        return templateModel;
    }

    @Override
    public Element serialize() {
        final Element element = new Element(STORE_KEY);
        element.setAttribute(COMPONENT_TEMPLATE_KEY, componentTemplateFile);
        element.setAttribute(SASS_TEMPLATE_KEY, sassTemplateFile);
        return element;
    }

    @Override
    public void deserialize(Element element) {
        setComponentTemplateFile(element.getAttributeValue(COMPONENT_TEMPLATE_KEY));
        setSassTemplateFile(element.getAttributeValue(SASS_TEMPLATE_KEY));
    }

    public boolean isComponentTemplateDefault() {
        return defaultComponentTemplateFile.equals(componentTemplateFile);
    }

    public boolean isSassTemplateDefault() {
        return defaultSassTemplateFile.equals(sassTemplateFile);
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentTemplateFile() {
        return componentTemplateFile;
    }

    public void setComponentTemplateFile(String componentTemplateFile) {
        if (componentTemplateFile == null || componentTemplateFile.isEmpty()) {
            this.componentTemplateFile = defaultComponentTemplateFile;
            return;
        }
        this.componentTemplateFile = componentTemplateFile;
    }

    public String getSassTemplateFile() {
        return sassTemplateFile;
    }

    public void setSassTemplateFile(String sassTemplateFile) {
        if (sassTemplateFile == null || sassTemplateFile.isEmpty()) {
            this.sassTemplateFile = defaultSassTemplateFile;
            return;
        }
        this.sassTemplateFile = sassTemplateFile;
    }

    public boolean equals(ComponentCreateOptions options) {
        return (options.getComponentTemplateFile().equals(componentTemplateFile)
                && options.getSassTemplateFile().equals(sassTemplateFile));
    }
}
