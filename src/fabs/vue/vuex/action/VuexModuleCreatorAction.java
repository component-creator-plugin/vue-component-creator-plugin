package fabs.vue.vuex.action;

import com.intellij.openapi.project.Project;
import fabs.util.AbstractCreatorAction;
import fabs.util.AbstractDialog;
import fabs.vue.vuex.VuexCreatorDialog;
import fabs.vue.vuex.data.VuexSettingsState;

public class VuexModuleCreatorAction extends AbstractCreatorAction {

    @Override
    protected AbstractDialog createDialog(Project project) {
        VuexSettingsState state = VuexSettingsState.getInstance(project);
        return new VuexCreatorDialog(state.getOptions());
    }
}
