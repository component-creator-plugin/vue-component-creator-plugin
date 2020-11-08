package io.fabs.vue.component.widget;

import io.fabs.util.AbstractOptions;
import io.fabs.util.TemplateUtils;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.Map;

public class ComponentCreateOptions extends AbstractOptions {
    public static final String STORE_KEY = "vcc.component";
    public static final String COMPONENT_TEMPLATE_KEY = "COMPONENT_TEMPLATE_KEY";
    public static final String SASS_TEMPLATE_KEY = "SASS_TEMPLATE_KEY";
    public static final String STORYBOOK_TEMPLATE_KEY = "STORYBOOK_TEMPLATE_KEY";
    public static final String SPEC_TEMPLATE_KEY = "SPEC_TEMPLATE_KEY";
    public static final String MARKDOWN_TEMPLATE_KEY = "MARKDOWN_TEMPLATE_KEY";

    private final String defaultComponentTemplateFile = "templates/component/{{componentName}}.vue";
    private final String defaultSassTemplateFile = "templates/component/_{{componentName}}.scss";
    private final String defaultStorybookTemplateFile = "templates/component/{{componentName}}.stories.js";
    private final String defaultSpecTemplateFile = "templates/component/{{componentName}}.spec.js";
    private final String defaultMDTemplateFile = "templates/component/{{componentName}}.md";

    private String componentTemplateFile = defaultComponentTemplateFile;
    private String sassTemplateFile = defaultSassTemplateFile;
    private String storybookTemplateFile = defaultStorybookTemplateFile;
    private String specTemplateFile = defaultSpecTemplateFile;
    private String mdTemplateFile = defaultMDTemplateFile;

    private boolean createSassFile = false;
    private boolean createStorybookFile = false;
    private boolean createSpecFile = false;
    private boolean createMDFile = false;

    private String componentName;

    @Override
    public ArrayList<String> getFiles() {
        ArrayList<String> files = new ArrayList<>();
        files.add(componentTemplateFile);

        if (createSassFile) {
            files.add(sassTemplateFile);
        }

        if (createStorybookFile) {
            files.add(storybookTemplateFile);
        }

        if (createSpecFile) {
            files.add(specTemplateFile);
        }

        if (createMDFile) {
            files.add(mdTemplateFile);
        }
        return files;
    }

    @Override
    public Map<String, Object> getTemplateVariables() {
        return TemplateUtils.createVariableMap(componentName);
    }

    @Override
    public Element serialize() {
        final Element element = new Element(STORE_KEY);
        if (!isComponentTemplateDefault()) {
            element.setAttribute(COMPONENT_TEMPLATE_KEY, componentTemplateFile);
        }

        if (!isSassTemplateDefault()) {
            element.setAttribute(SASS_TEMPLATE_KEY, sassTemplateFile);
        }

        if (!isStorybookTemplateDefault()) {
            element.setAttribute(STORYBOOK_TEMPLATE_KEY, storybookTemplateFile);
        }

        if (!isSpecTemplateDefault()) {
            element.setAttribute(SPEC_TEMPLATE_KEY, specTemplateFile);
        }

        if (!isMDTemplateDefault()) {
            element.setAttribute(MARKDOWN_TEMPLATE_KEY, mdTemplateFile);
        }
        return element;
    }

    @Override
    public void deserialize(Element element) {
        setComponentTemplateFile(element.getAttributeValue(COMPONENT_TEMPLATE_KEY));
        setSassTemplateFile(element.getAttributeValue(SASS_TEMPLATE_KEY));
        setStorybookTemplateFile(element.getAttributeValue(STORYBOOK_TEMPLATE_KEY));
        setSpecTemplateFile(element.getAttributeValue(SPEC_TEMPLATE_KEY));
        setMdTemplateFile(element.getAttributeValue(MARKDOWN_TEMPLATE_KEY));
    }

    public boolean isComponentTemplateDefault() {
        return defaultComponentTemplateFile.equals(componentTemplateFile);
    }

    public boolean isSassTemplateDefault() {
        return defaultSassTemplateFile.equals(sassTemplateFile);
    }

    public boolean isStorybookTemplateDefault() {
        return defaultStorybookTemplateFile.equals(storybookTemplateFile);
    }

    public boolean isSpecTemplateDefault() {
        return defaultSpecTemplateFile.equals(specTemplateFile);
    }

    public boolean isMDTemplateDefault() {
        return defaultMDTemplateFile.equals(mdTemplateFile);
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

    public String getStorybookTemplateFile() {
        return storybookTemplateFile;
    }

    public void setStorybookTemplateFile(String storybookTemplateFile) {
        if (storybookTemplateFile == null || storybookTemplateFile.isEmpty()) {
            this.storybookTemplateFile = defaultStorybookTemplateFile;
            return;
        }
        this.storybookTemplateFile = storybookTemplateFile;
    }

    public void setCreateSassFile(boolean createSassFile) {
        this.createSassFile = createSassFile;
    }

    public void setCreateStorybookFile(boolean createStorybookFile) {
        this.createStorybookFile = createStorybookFile;
    }

    public String getSpecTemplateFile() {
        return specTemplateFile;
    }

    public void setSpecTemplateFile(String specTemplateFile) {
        if (specTemplateFile == null || specTemplateFile.isEmpty()) {
            this.specTemplateFile = defaultSpecTemplateFile;
            return;
        }
        this.specTemplateFile = specTemplateFile;
    }

    public String getMdTemplateFile() {
        return mdTemplateFile;
    }

    public void setMdTemplateFile(String file) {
        if (file == null || file.isEmpty()) {
            mdTemplateFile = defaultMDTemplateFile;
            return;
        }
        mdTemplateFile = file;
    }

    public void setCreateSpecFile(boolean createSpecFile) {
        this.createSpecFile = createSpecFile;
    }

    public void setCreateMDFile(boolean createMDFile) {
        this.createMDFile = createMDFile;
    }

    public boolean equals(ComponentCreateOptions options) {
        return (options.getComponentTemplateFile().equals(componentTemplateFile)
                && options.getStorybookTemplateFile().equals(storybookTemplateFile)
                && options.getSassTemplateFile().equals(sassTemplateFile)
                && options.getSpecTemplateFile().equals(specTemplateFile)
                && options.getMdTemplateFile().equals(mdTemplateFile)
        );
    }
}
