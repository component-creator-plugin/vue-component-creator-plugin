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

        dialog.pack();
        dialog.setVisible(true);

        final String componentName = dialog.getComponentName();
        final VirtualFile[] files = DataKeys.VIRTUAL_FILE_ARRAY.getData(e.getDataContext());

        VirtualFile targetLocation = getLocation(files);

        ApplicationManager.getApplication().runWriteAction(new RunnableCreator(targetLocation, componentName));
    }

    private VirtualFile getLocation(VirtualFile[] files) {
        final List<VirtualFile> filesList = Arrays.asList(files);
        if (filesList.size() <= 0) {
            return null;
        }
        final VirtualFile file = filesList.get(0);
        if (file.isDirectory()) {
            return file;
        }
        return file.getParent();
    }
}
