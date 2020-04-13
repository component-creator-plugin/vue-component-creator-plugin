package fabs.util;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public abstract class AbstractSettingsUI<T extends AbstractOptions> implements Configurable {
    protected Project project;
    private String title;
    protected AbstractSettingsForm ui;


    public AbstractSettingsUI(Project project, String title) {
        this.project = project;
        this.title = title;
    }

    public abstract T getOptions();

    public abstract AbstractSettingsForm createUi();

    @Override
    public void apply() throws ConfigurationException {
        ui.applySettings(getOptions());
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return title;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (ui == null) {
            ui = createUi();
        }
        reset();

        return ui.getMainPanel();
    }


    @Override
    public boolean isModified() {
        return ui.isDirty();
    }
}
