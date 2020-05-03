package fabs.vue.component.ui;

import fabs.util.AbstractSettingsForm;
import fabs.vue.component.data.ComponentCreateOptions;

import javax.swing.*;

public class SettingsForm extends AbstractSettingsForm<ComponentCreateOptions> {
    private JButton componentBrowseBtn;
    private JPanel mainPanel;
    private JTextField componentTemplateInput;
    private JTextField sassTemplateInput;
    private JButton browseSassBtn;

    public SettingsForm(ComponentCreateOptions options) {
        super(options);

        if (!options.isComponentTemplateDefault()) {
            componentTemplateInput.setText(options.getComponentTemplateFile());
        }

        if (!options.isSassTemplateDefault()) {
            sassTemplateInput.setText(options.getSassTemplateFile());
        }

        componentBrowseBtn.addActionListener(e -> onBrowseButtonClicked(e, componentTemplateInput));
        browseSassBtn.addActionListener(e -> onBrowseButtonClicked(e, sassTemplateInput));
    }

    @Override
    public JComponent getMainPanel() {
        return this.mainPanel;
    }

    @Override
    public boolean isDirty() {
        ComponentCreateOptions o = new ComponentCreateOptions();
        o.setComponentTemplateFile(componentTemplateInput.getText());
        o.setSassTemplateFile(sassTemplateInput.getText());
        return !options.equals(o);
    }

    @Override
    public void applySettings(ComponentCreateOptions options) {
        String template = componentTemplateInput.getText();
        String sass = sassTemplateInput.getText();

        options.setComponentTemplateFile(template);
        options.setSassTemplateFile(sass);
    }
}
