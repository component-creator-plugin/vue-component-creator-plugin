package io.fabs.vue.component.widget;

import com.intellij.openapi.project.Project;
import io.fabs.util.AbstractCreatorAction;
import io.fabs.util.AbstractDialog;
import io.fabs.vue.component.ComponentSettingsState;

public class ComponentCreatorAction extends AbstractCreatorAction {
    protected AbstractDialog<ComponentCreateOptions> createDialog(Project project) {
        ComponentSettingsState state = ComponentSettingsState.getInstance(project);
        return new ComponentCreatorDialog(state.getOptions());
    }
}
