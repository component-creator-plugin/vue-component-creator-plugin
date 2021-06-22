package io.fabs.util;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Map;

public class Creator implements Runnable {
    protected VirtualFile directory;
    protected String componentName;
    protected String directoryName;
    protected AbstractOptions options;

    public Creator(VirtualFile directory, String directoryName, String componentName, AbstractOptions options) {
        this.directory = directory;
        this.componentName = componentName;
        this.directoryName = directoryName;
        this.options = options;
    }

    public void create() throws Exception {
        VirtualFile existingDirectory = VfsUtil.findRelativeFile(directory, componentName);
        if (existingDirectory != null) {
            return;
        }

        this.writeFiles();
    }

    protected void writeFiles() throws Exception {
        VirtualFile componentDirectory = directory.createChildDirectory(directory, directoryName);
        Map<String, String> variableMap = options.getTemplateVariables();

        String[] files = options.getFileList();

        for (String filePath : files) {
            String file = Paths.get(filePath).toString();
            String templateName = TemplateRenderer.transformTemplateName(file, variableMap);
//            try {
                String content = TemplateRenderer.render(file, variableMap);
                FileUtils.writeFile(content, componentDirectory.createChildData(componentDirectory, templateName));
//            } catch (Exception e) {
//                throw new Exception("" + (e.getMessage()) + " for file " + file, e.fillInStackTrace());
//            }
        }
    }

    @Override
    public void run() {
        try {
            this.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
