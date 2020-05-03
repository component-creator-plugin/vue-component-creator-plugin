package fabs.vue.vuex.settings;

import com.intellij.openapi.project.Project;
import fabs.util.AbstractSettingsForm;
import fabs.util.AbstractSettingsUI;
import fabs.vue.component.data.ComponentCreateOptions;
import fabs.vue.component.data.ComponentSettingsState;
import fabs.vue.component.ui.SettingsForm;
import fabs.vue.vuex.data.VuexCreateOptions;
import fabs.vue.vuex.data.VuexSettingsState;
import fabs.vue.vuex.ui.VuexSettingsForm;

public class VuexSettings extends AbstractSettingsUI<VuexCreateOptions> {
    public VuexSettings(Project project) {
        super(project, "Component");
    }

    @Override
    public VuexCreateOptions getOptions() {
        return VuexSettingsState.getInstance(project).getOptions();
    }

    @Override
    public AbstractSettingsForm createUi() {
        return new VuexSettingsForm(getOptions());
    }
}
