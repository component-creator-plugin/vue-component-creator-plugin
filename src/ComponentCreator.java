import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

public class ComponentCreator {
    protected VirtualFile directory;
    protected String componentName;

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

        createJavascriptFile(componentDirectory);
        createCSSFile(componentDirectory);
    }

    private String getFileContent(String fileName) {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceStream = classLoader.getResourceAsStream(fileName);

        Scanner scanner = new Scanner(resourceStream);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.append(line).append("\n");
        }

        scanner.close();
        return result.toString();
    }

    private void createJavascriptFile(VirtualFile componentDirectory) throws IOException {
        String fileName = "templates/component.js";
        VirtualFile jsFile = componentDirectory.createChildData(componentDirectory, componentName + ".js");

        String newContent = getFileContent(fileName).replaceAll("%COMPONENT_NAME%", componentName);
        jsFile.setBinaryContent(newContent.getBytes());
    }

    private void createCSSFile(VirtualFile componentDirectory) throws IOException {
        String fileName = "templates/component.scss";
        VirtualFile cssFile = componentDirectory.createChildData(componentDirectory, "_" + componentName + ".scss");
        String newContent = getFileContent(fileName).replaceAll("%COMPONENT_NAME%", componentName);
        cssFile.setBinaryContent(newContent.getBytes());
    }
}
