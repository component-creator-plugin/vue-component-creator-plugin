package io.fabs.vue.component.settings;

import io.fabs.vue.component.widget.ComponentCreateOptions;
import io.fabs.util.AbstractSettingsForm;

import javax.swing.*;

public class SettingsForm extends AbstractSettingsForm<ComponentCreateOptions> {
    private JButton componentBrowseBtn;
    private JPanel mainPanel;
    private JTextField componentTemplateInput;
    private JTextField sassTemplateInput;
    private JButton browseSassBtn;
    private JTextField storybookTemplateInput;
    private JButton browseStorybookBtn;
    private JTextField specTemplateInput;
    private JButton specBrowseBtn;
    private JTextField mdTemplateInput;
    private JButton mdBrowseBtn;

    public SettingsForm(ComponentCreateOptions options) {
        super(options);

        if (!options.isComponentTemplateDefault()) {
            componentTemplateInput.setText(options.getComponentTemplateFile());
        }

        if (!options.isSassTemplateDefault()) {
            sassTemplateInput.setText(options.getSassTemplateFile());
        }

        if (!options.isStorybookTemplateDefault()) {
            storybookTemplateInput.setText(options.getStorybookTemplateFile());
        }

        if (!options.isSpecTemplateDefault()) {
            specTemplateInput.setText(options.getSpecTemplateFile());
        }

        if (!options.isMDTemplateDefault()) {
            mdTemplateInput.setText(options.getMdTemplateFile());
        }

        componentBrowseBtn.addActionListener(e -> onBrowseButtonClicked(e, componentTemplateInput));
        browseSassBtn.addActionListener(e -> onBrowseButtonClicked(e, sassTemplateInput));
        browseStorybookBtn.addActionListener(e -> onBrowseButtonClicked(e, storybookTemplateInput));
        specBrowseBtn.addActionListener(e -> onBrowseButtonClicked(e, specTemplateInput));
        mdBrowseBtn.addActionListener(e -> onBrowseButtonClicked(e, mdTemplateInput));
    }

    @Override
    public JComponent getMainPanel() {
        return this.mainPanel;
    }

    @Override
    public boolean isDirty() {
        ComponentCreateOptions o = new ComponentCreateOptions();
        applySettings(o);
        return !options.equals(o);
    }

    @Override
    public void applySettings(ComponentCreateOptions options) {
        String template = componentTemplateInput.getText();
        String sass = sassTemplateInput.getText();
        String storybook = storybookTemplateInput.getText();
        String spec = specTemplateInput.getText();

        options.setComponentTemplateFile(template);
        options.setSassTemplateFile(sass);
        options.setStorybookTemplateFile(storybook);
        options.setSpecTemplateFile(spec);
        options.setMdTemplateFile(mdTemplateInput.getText());
    }
}
