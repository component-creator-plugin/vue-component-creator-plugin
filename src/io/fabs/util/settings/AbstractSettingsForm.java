package io.fabs.util.settings;

import io.fabs.util.AbstractOptions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class AbstractSettingsForm<T extends AbstractOptions> {
    private JFileChooser fileChooser;
    protected T options;

    public AbstractSettingsForm(T options) {
        this.options = options;
        fileChooser = new JFileChooser();
    }

    public abstract JComponent getMainPanel();

    public abstract boolean isDirty();

    public abstract void applySettings(T options);

    protected void onBrowseButtonClicked(ActionEvent e, JTextField input) {
        if (fileChooser.showOpenDialog(getMainPanel()) == JFileChooser.APPROVE_OPTION) {
            input.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }
}
