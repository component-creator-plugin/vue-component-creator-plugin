package fabs.vuex;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import fabs.util.AbstractCreator;
import fabs.util.FileUtils;
import fabs.util.TemplateRenderer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class VuexModuleCreator extends AbstractCreator {
    protected VirtualFile directory;
    protected String componentName;
    protected String[] listOfFilesToCopy;
    protected Map<String, Object> templateModel;


    public VuexModuleCreator(VirtualFile directory,
                             String componentName,
                             String[] listOfFilesToCopy,
                             Map<String, Object> templateModel) {
        this.directory = directory;
        this.componentName = componentName;
        this.listOfFilesToCopy = listOfFilesToCopy;
        this.templateModel = templateModel;
    }

    @Override
    public void create() throws IOException {
        VirtualFile existingDirectory = VfsUtil.findRelativeFile(directory, componentName);
        if (existingDirectory != null) {
            return;
        }

        VirtualFile componentDirectory = directory.createChildDirectory(directory, componentName);

        copyAllFiles(this.listOfFilesToCopy, componentDirectory);
    }

    protected void copyAllFiles(String[] files, VirtualFile destinationDirectory) throws IOException {
        for (int i = 0; i < files.length; i++) {
            String sourceTemplateFile = files[i];

            Path filePath = Paths.get(sourceTemplateFile);
            String fileName = filePath.getFileName().toString().replace(".mustache", "");

            VirtualFile file = destinationDirectory.createChildData(destinationDirectory, fileName);

            FileUtils utils = new FileUtils();
            TemplateRenderer renderer = new TemplateRenderer();
            utils.writeFile(renderer.render(sourceTemplateFile, templateModel), file);
        }
    }
}
