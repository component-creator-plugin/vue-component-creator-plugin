package fabs.component;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import fabs.util.AbstractCreator;
import fabs.util.FileUtil;

import java.io.IOException;

import static fabs.util.FileUtil.COMPONENT_NAME_TOKEN;

public class ComponentCreator extends AbstractCreator {
    protected VirtualFile directory;
    protected String componentName;
    private final String vueComponentFile = "templates/component/component.vue";
    private final String cssComponentFile = "templates/component/component.scss";

    public ComponentCreator(VirtualFile directory, String componentName) {
        this.directory = directory;
        this.componentName = componentName;
    }

    public void create() throws IOException {
        VirtualFile existingDirectory = VfsUtil.findRelativeFile(directory, componentName);
        if (existingDirectory != null) {
            return;
        }

        VirtualFile componentDirectory = directory.createChildDirectory(directory, componentName);

        FileUtil fu = new FileUtil();
        String jsFileContent = fu.getContent(vueComponentFile).replaceAll(COMPONENT_NAME_TOKEN, componentName);
        VirtualFile jsFile = componentDirectory.createChildData(componentDirectory, getJsFileName());
        fu.writeFile(jsFileContent, jsFile);


        String scssFileContent = fu.getContent(cssComponentFile).replaceAll(COMPONENT_NAME_TOKEN, componentName);
        VirtualFile scssFile = componentDirectory.createChildData(componentDirectory, getCssFileName());
        fu.writeFile(scssFileContent, scssFile);
    }


    public VirtualFile getJsVirtualFile() {
        return directory.findFileByRelativePath(componentName + "/" + getJsFileName());
    }

    public VirtualFile getCssVirtualFile() {
        return directory.findFileByRelativePath(componentName + "/" + getCssFileName());
    }



    private String getCssFileName() {
        return "_" + componentName + ".scss";
    }

    private String getJsFileName() {
        return componentName + ".vue";
    }

}
