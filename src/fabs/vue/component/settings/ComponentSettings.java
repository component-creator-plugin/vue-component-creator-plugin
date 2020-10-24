package fabs.vue.component.settings;

import com.intellij.openapi.project.Project;
import io.fabs.util.AbstractSettingsForm;
import io.fabs.util.AbstractSettingsUI;
import fabs.vue.component.data.ComponentCreateOptions;
import fabs.vue.component.data.ComponentSettingsState;
import fabs.vue.component.ui.SettingsForm;

public class ComponentSettings extends AbstractSettingsUI<ComponentCreateOptions> {

    public ComponentSettings(Project project) {
        super(project, "Component");
    }

    @Override
    public ComponentCreateOptions getOptions() {
        return ComponentSettingsState.getInstance(project).getOptions();
    }

    @Override
    public AbstractSettingsForm createUi() {
        return new SettingsForm(getOptions());
    }
}
