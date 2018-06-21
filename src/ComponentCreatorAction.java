import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;

import java.util.*;

public class ComponentCreatorAction extends AnAction {


    @Override
    public void update(AnActionEvent anActionEvent) {
        Project project = anActionEvent.getProject();
        Navigatable navigatable = anActionEvent.getData(CommonDataKeys.NAVIGATABLE);
        anActionEvent.getPresentation().setEnabledAndVisible(project != null && navigatable != null);
    }


    @Override
    public void actionPerformed(AnActionEvent e) {
        ComponentCreatorDialog dialog = new ComponentCreatorDialog();
        VirtualFile selectedLocation = e.getData(CommonDataKeys.VIRTUAL_FILE);
        VirtualFile targetLocation = getLocation(selectedLocation);

        dialog.pack();
        dialog.setVisible(true);

        final String componentName = dialog.getComponentName();


        ApplicationManager.getApplication().runWriteAction(new RunnableCreator(targetLocation, componentName));
    }

    private VirtualFile getLocation(VirtualFile file) {
        if (file.isDirectory()) {
            return file;
        }
        return file.getParent();
    }
}
