package fabs.vue.component.action;

import com.intellij.openapi.project.Project;
import fabs.util.AbstractCreatorAction;
import fabs.util.AbstractDialog;
import fabs.vue.component.data.ComponentCreateOptions;
import fabs.vue.component.ui.ComponentCreatorDialog;

public class ComponentCreatorAction extends AbstractCreatorAction {
    protected AbstractDialog createDialog(Project project) {
        return new ComponentCreatorDialog(new ComponentCreateOptions());
    }
}
