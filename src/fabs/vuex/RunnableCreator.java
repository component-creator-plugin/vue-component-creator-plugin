package fabs.vuex;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.IOException;
import java.util.Map;

public class RunnableCreator implements Runnable {
    private VuexModuleCreator creator;

    public RunnableCreator(VirtualFile directory,
                           String componentName,
                           String[] listOfFilesToCopy,
                           Map<String, Object> templateModel) {
        creator = new VuexModuleCreator(
                directory,
                componentName,
                listOfFilesToCopy,
                templateModel);
    }

    @Override
    public void run() {
        try {
            creator.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
