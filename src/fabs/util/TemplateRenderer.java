package fabs.util;

import com.intellij.openapi.vfs.VirtualFile;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class TemplateRenderer {

    public void createFile(File source, VirtualFile destinationFile, Map<String, Object> context) throws IOException {
        String template = render(source, context);
        destinationFile.setBinaryContent(template.getBytes());
    }

    public String render(File file, Map<String, Object> context) throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
        Template tmpl = Mustache.compiler().compile(fileReader);
        return tmpl.execute(context);
    }
}
