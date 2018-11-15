package fabs.vuex;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.IOException;

public class RunnableCreator implements Runnable {
    private VuexModuleCreator creator;

    public RunnableCreator(VirtualFile directory, String componentName) {
        creator = new VuexModuleCreator(directory, componentName);
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
