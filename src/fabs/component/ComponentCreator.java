package fabs.component;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import fabs.util.AbstractCreator;
import fabs.util.FileUtils;
import fabs.util.TemplateRenderer;

import java.io.IOException;
import java.util.Map;

public class ComponentCreator extends AbstractCreator {
    protected VirtualFile directory;
    protected String componentName;
    protected Map<String, Object> templateModel;

    private final String vueTemplateFile = "templates/component/component.vue.mustache";
    private final String sassTemplateFile = "templates/component/component.scss.mustache";

    public ComponentCreator(VirtualFile directory, String componentName, Map<String, Object> templateModel) {
        this.directory = directory;
        this.componentName = componentName;
        this.templateModel = templateModel;
    }

    public void create() throws IOException {
        VirtualFile existingDirectory = VfsUtil.findRelativeFile(directory, componentName);
        if (existingDirectory != null) {
            return;
        }

        VirtualFile componentDirectory = directory.createChildDirectory(directory, componentName);
        VirtualFile componentDestFile = componentDirectory.createChildData(componentDirectory, getJsFileName());
        VirtualFile scssDestFile = componentDirectory.createChildData(componentDirectory, getCssFileName());

        FileUtils utils = new FileUtils();
        TemplateRenderer renderer = new TemplateRenderer();

        utils.writeFile(renderer.render(vueTemplateFile, templateModel), componentDestFile);
        utils.writeFile(renderer.render(sassTemplateFile, templateModel), scssDestFile);
    }


    private String getCssFileName() {
        return "_" + componentName + ".scss";
    }

    private String getJsFileName() {
        return componentName + ".vue";
    }

}
