package io.fabs.vue.component.settings;

import com.intellij.openapi.project.Project;
import io.fabs.vue.component.ComponentSettingsState;
import io.fabs.util.AbstractSettingsForm;
import io.fabs.util.AbstractSettingsUI;
import io.fabs.vue.component.widget.ComponentCreateOptions;

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
