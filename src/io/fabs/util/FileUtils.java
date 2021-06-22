package io.fabs.util;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.*;
import java.util.Scanner;

public class FileUtils {

    /**
     * Get the file content
     */
    public String getContent(String filePath) throws FileNotFoundException {
        StringBuilder result = new StringBuilder("");
        InputStream resourceStream = getClass().getResourceAsStream(filePath);

        Scanner scanner = new Scanner(resourceStream);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.append(line).append("\n");
        }

        scanner.close();
        return result.toString();
    }

    public static void writeFile(String content, VirtualFile destinationFile) throws IOException {
        destinationFile.setBinaryContent(content.getBytes());
    }

    public static boolean fileExists(String filePath) {
        File tmpDir = new File(filePath);
        return tmpDir.exists();
    }
}
