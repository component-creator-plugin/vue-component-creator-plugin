package fabs.util;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileUtils {

    /**
     * Get the file content
     *
     * @param fileName
     * @return
     */
    public String getContent(String fileName) {
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

    public void writeFile(String content, VirtualFile destinationFile) throws IOException {
        destinationFile.setBinaryContent(content.getBytes());
    }
}
