package io.fabs.vue.vuex.widget;

import com.intellij.openapi.project.Project;
import io.fabs.util.AbstractCreatorAction;
import io.fabs.util.AbstractDialog;
import io.fabs.vue.vuex.widget.VuexCreatorDialog;
import io.fabs.vue.vuex.VuexSettingsState;

public class VuexModuleCreatorAction extends AbstractCreatorAction {

    @Override
    protected AbstractDialog createDialog(Project project) {
        VuexSettingsState state = VuexSettingsState.getInstance(project);
        return new VuexCreatorDialog(state.getOptions());
    }
}
