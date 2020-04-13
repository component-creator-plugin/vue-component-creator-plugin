package fabs.util;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.*;
import java.util.Scanner;

public class FileUtils {

    /**
     * Get the file content
     */
    public String getContent(String filePath) throws FileNotFoundException {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceStream = classLoader.getResourceAsStream(filePath);

        File tmpFile = new File(filePath);
        if (tmpFile.exists()) {
            resourceStream = new FileInputStream(filePath);
        }

        Scanner scanner = new Scanner(resourceStream);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.append(line).append("\n");
        }

        scanner.close();
        return result.toString();
    }

    public void writeFile(String content, VirtualFile destinationFile) throws IOException {
        destinationFile.setBinaryContent(content.getBytes());
    }
}
