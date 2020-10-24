package fabs.vue.vuex.settings;

import com.intellij.openapi.project.Project;
import io.fabs.util.AbstractSettingsForm;
import io.fabs.util.AbstractSettingsUI;
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
