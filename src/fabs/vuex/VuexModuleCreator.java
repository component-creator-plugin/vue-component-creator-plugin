package fabs.vuex;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import fabs.util.AbstractCreator;
import fabs.util.FileUtils;
import fabs.util.TemplateRenderer;

import java.io.IOException;
import java.util.Map;

public class VuexModuleCreator extends AbstractCreator {
    protected VirtualFile directory;
    protected String componentName;
    protected Map<String, Object> templateModel;
    protected String[] files;


    public VuexModuleCreator(VirtualFile directory,
                             String componentName,
                             Map<String, Object> templateModel,
                             String[] files) {
        this.directory = directory;
        this.componentName = componentName;
        this.files = files;
        this.templateModel = templateModel;
    }

    @Override
    public void create() throws IOException {
        VirtualFile existingDirectory = VfsUtil.findRelativeFile(directory, componentName);
        if (existingDirectory != null) {
            return;
        }

        VirtualFile componentDirectory = directory.createChildDirectory(directory, componentName);
        FileUtils utils = new FileUtils();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            utils.writeFile(TemplateRenderer.render(file, templateModel),
                    componentDirectory.createChildData(componentDirectory, TemplateRenderer.transformTemplateName(file, componentName)
                    ));
        }
    }
}
