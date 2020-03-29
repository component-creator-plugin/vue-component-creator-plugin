package fabs.util;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.IOException;
import java.util.Map;

public class Creator implements Runnable {
    protected VirtualFile directory;
    protected String componentName;
    protected String directoryName;
    protected String[] files;
    protected Map<String, Object> templateModel;

    public Creator(VirtualFile directory, String directoryName,String componentName, Map<String, Object> templateModel, String[] files) {
        this.directory = directory;
        this.componentName = componentName;
        this.directoryName = directoryName;
        this.templateModel = templateModel;
        this.files = files;
    }

    public void create() throws IOException {
        VirtualFile existingDirectory = VfsUtil.findRelativeFile(directory, componentName);
        if (existingDirectory != null) {
            return;
        }

        this.writeFiles();
    }

    protected void writeFiles() throws IOException {
        FileUtils utils = new FileUtils();
        TemplateRenderer renderer = new TemplateRenderer();
        VirtualFile componentDirectory = directory.createChildDirectory(directory, directoryName);

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            utils.writeFile(renderer.render(file, templateModel), componentDirectory.createChildData(componentDirectory, StringFormatter.transformTemplateName(file, componentName)));
        }
    }

    @Override
    public void run() {
        try {
            this.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
