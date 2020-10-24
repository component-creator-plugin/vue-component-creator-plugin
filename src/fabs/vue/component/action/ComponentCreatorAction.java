package fabs.vue.component.action;

import com.intellij.openapi.project.Project;
import io.fabs.util.AbstractCreatorAction;
import io.fabs.util.AbstractDialog;
import fabs.vue.component.data.ComponentSettingsState;
import fabs.vue.component.ui.ComponentCreatorDialog;

public class ComponentCreatorAction extends AbstractCreatorAction {
    protected AbstractDialog createDialog(Project project) {
        ComponentSettingsState state = ComponentSettingsState.getInstance(project);
        return new ComponentCreatorDialog(state.getOptions());
    }
}
