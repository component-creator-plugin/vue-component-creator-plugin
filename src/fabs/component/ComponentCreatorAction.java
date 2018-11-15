package fabs.component;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import fabs.util.AbstractCreatorAction;

public class ComponentCreatorAction extends AbstractCreatorAction {

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

        if (dialog.isCanceled()) {
            return;
        }

        ComponentCreator c = new ComponentCreator(targetLocation, componentName);

        ApplicationManager.getApplication().runWriteAction(new RunnableCreator(targetLocation, componentName));

        FileEditorManager.getInstance(e.getProject()).openFile(c.getJsVirtualFile(), true);
        FileEditorManager.getInstance(e.getProject()).openFile(c.getCssVirtualFile(), true);
    }
}
