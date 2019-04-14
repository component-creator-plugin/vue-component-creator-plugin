package fabs.vuex;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.vfs.VirtualFile;
import fabs.util.AbstractCreatorAction;

import java.awt.*;

public class VuexModuleCreatorAction extends AbstractCreatorAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        VuexCreatorDialog dialog = new VuexCreatorDialog();
        VirtualFile selectedLocation = e.getData(CommonDataKeys.VIRTUAL_FILE);
        VirtualFile targetLocation = getLocation(selectedLocation);


        final int width = dialog.getWidth();
        final int height = dialog.getHeight();
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (width / 2);
        int y = (screenSize.height / 2) - (height / 2);
        dialog.setLocation(x, y);

        dialog.pack();
        dialog.setVisible(true);


        final String componentName = dialog.getComponentName();
        String[] listOfFilesToCopy = dialog.getListOfFilesToCopy();
        String mutationTypeFilePath = dialog.getMutationFilePathForTemplate();

        if (dialog.isCanceled()) {
            return;
        }

        ApplicationManager.getApplication().runWriteAction(
                new RunnableCreator(
                        targetLocation,
                        componentName,
                        listOfFilesToCopy,
                        mutationTypeFilePath,
                        dialog.getMutationName(),
                        dialog.getTemplateVars()
                )
        );
    }
}
