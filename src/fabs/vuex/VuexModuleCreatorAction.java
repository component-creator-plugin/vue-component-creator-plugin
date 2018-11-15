package fabs.vuex;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.vfs.VirtualFile;
import fabs.util.AbstractCreatorAction;

public class VuexModuleCreatorAction extends AbstractCreatorAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        VuexCreatorDialog dialog = new VuexCreatorDialog();
        VirtualFile selectedLocation = e.getData(CommonDataKeys.VIRTUAL_FILE);
        VirtualFile targetLocation = getLocation(selectedLocation);

        dialog.pack();
        dialog.setVisible(true);

        final String componentName = dialog.getComponentName();

        if (dialog.isCanceled()) {
            return;
        }

        ApplicationManager.getApplication().runWriteAction(new RunnableCreator(targetLocation, componentName));
    }
}
