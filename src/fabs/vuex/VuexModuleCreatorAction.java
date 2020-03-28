package fabs.vuex;

import com.intellij.openapi.vfs.VirtualFile;
import fabs.util.AbstractCreator;
import fabs.util.AbstractCreatorAction;
import fabs.util.AbstractDialog;

import java.util.Map;

public class VuexModuleCreatorAction extends AbstractCreatorAction {

    @Override
    protected AbstractCreator createCreator(VirtualFile directory, String componentName, Map<String, Object> templateModel, String[] files) {
        return new VuexModuleCreator(directory, componentName, templateModel, files);
    }

    @Override
    protected AbstractDialog createDialog() {
        return new VuexCreatorDialog();
    }
}
