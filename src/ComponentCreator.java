import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.*;
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

    /**
     * Get the file content
     * @param fileName
     * @return
     */
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

    /**
     * Create vue module
     * @param componentDirectory
     * @throws IOException
     */
    private void createJavascriptFile(VirtualFile componentDirectory) throws IOException {
        String fileName = "templates/component.vue";
        VirtualFile jsFile = componentDirectory.createChildData(componentDirectory, componentName + ".vue");

        String newContent = getFileContent(fileName).replaceAll("%COMPONENT_NAME%", componentName);
        jsFile.setBinaryContent(newContent.getBytes());
    }

    /**
     * Create css module
     * @param componentDirectory
     * @throws IOException
     */
    private void createCSSFile(VirtualFile componentDirectory) throws IOException {
        String fileName = "templates/component.scss";
        VirtualFile cssFile = componentDirectory.createChildData(componentDirectory, "_" + componentName + ".scss");
        String newContent = getFileContent(fileName).replaceAll("%COMPONENT_NAME%", componentName);
        cssFile.setBinaryContent(newContent.getBytes());
    }
}
