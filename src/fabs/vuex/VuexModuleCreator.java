package fabs.vuex;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import fabs.util.AbstractCreator;
import fabs.util.FileUtil;
import fabs.util.TokenReplacer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VuexModuleCreator extends AbstractCreator {

    protected VirtualFile directory;
    protected String componentName;
    public final String actionsFile = "templates/vuex/actions.js";
    public final String gettersFile = "templates/vuex/getters.js";
    public final String indexFile = "templates/vuex/index.js";
    public final String mutationsFile = "templates/vuex/mutations.js";
    public final String storeFile = "templates/vuex/store.js";


    public VuexModuleCreator(VirtualFile directory, String componentName) {
        this.directory = directory;
        this.componentName = componentName;
    }

    @Override
    public void create() throws IOException {
        VirtualFile existingDirectory = VfsUtil.findRelativeFile(directory, componentName);
        if (existingDirectory != null) {
            return;
        }

        VirtualFile componentDirectory = directory.createChildDirectory(directory, componentName);

        copyAllFiles(new String[]{actionsFile, gettersFile, indexFile, mutationsFile, storeFile}, componentDirectory, componentName);
    }

    protected void copyAllFiles(String[] files, VirtualFile destinationDirectory, String componentName) throws IOException {
        for (int i = 0; i < files.length; i++) {
            String sourceFile = files[i];

            FileUtil fu = new FileUtil();
            Path filePath = Paths.get(sourceFile);
            String fileName = filePath.getFileName().toString();


            String fileContent = fu.getContent(sourceFile);
            fileContent = TokenReplacer.replace(fileContent, componentName);

            VirtualFile file = destinationDirectory.createChildData(destinationDirectory, fileName);
            fu.writeFile(fileContent, file);
        }
    }
}
