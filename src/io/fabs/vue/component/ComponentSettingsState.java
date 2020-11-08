package io.fabs.vue.component;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import io.fabs.vue.component.widget.ComponentCreateOptions;
import io.fabs.util.AbstractPersistentState;

@State(
        name = "ComponentSettings",
        storages = {
                @Storage("/vcc_v2.xml")
        }
)
public class ComponentSettingsState extends AbstractPersistentState<ComponentCreateOptions> {

    public ComponentSettingsState() {
        super(new ComponentCreateOptions());
    }

    public static ComponentSettingsState getInstance(Project project) {
        return ServiceManager.getService(project, ComponentSettingsState.class);
    }
}
