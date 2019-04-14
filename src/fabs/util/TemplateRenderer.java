package fabs.util;


import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TwigRenderer {

    public JtwigModel createModel(String componentName){
        return JtwigModel
                .newModel()
                .with("componentName", componentName);
    }

    public void render(String sourceFile, File destinationFile, JtwigModel dataModel) throws IOException {
        JtwigTemplate template = JtwigTemplate.classpathTemplate(sourceFile);

        if (!destinationFile.exists()) {
            destinationFile.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(destinationFile);
        template.render(dataModel, fos);
    }
}
