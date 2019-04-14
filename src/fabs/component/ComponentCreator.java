package fabs.component;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import fabs.util.AbstractCreator;
import fabs.util.TemplateRenderer;

import java.io.File;
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

        TemplateRenderer renderer = new TemplateRenderer();
        File vueFile = new File(getClass().getClassLoader().getResource(vueTemplateFile).getFile());
        File sassFile = new File(getClass().getClassLoader().getResource(sassTemplateFile).getFile());

        renderer.createFile(vueFile, componentDestFile, templateModel);
        renderer.createFile(sassFile, scssDestFile, templateModel);
    }


    private String getCssFileName() {
        return "_" + componentName + ".scss";
    }

    private String getJsFileName() {
        return componentName + ".vue";
    }

}
