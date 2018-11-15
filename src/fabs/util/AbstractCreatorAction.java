package fabs.util;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.vfs.VirtualFile;

public abstract class AbstractCreatorAction extends AnAction {

    protected VirtualFile getLocation(VirtualFile file) {
        if (file.isDirectory()) {
            return file;
        }
        return file.getParent();
    }

}
