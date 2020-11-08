package io.fabs.vue.vuex.ui;

import io.fabs.util.AbstractSettingsForm;
import io.fabs.vue.vuex.data.VuexCreateOptions;

import javax.swing.*;

public class VuexSettingsForm extends AbstractSettingsForm<VuexCreateOptions> {

    private JPanel mainPanel;
    private JTextField indexTemplateInput;
    private JTextField actionsTemplateInput;
    private JTextField gettersTemplateInput;
    private JTextField mutationsTemplateInput;
    private JTextField stateTemplateInput;
    private JTextField typesTemplateInput;
    private JButton indexTemplateBrowseBtn;
    private JButton actionsTemplateBrowseBtn;
    private JButton gettersTemplateBrowseBtn;
    private JButton mutationsTemplateBrowseBtn;
    private JButton stateTemplateBrowseBtn;
    private JButton typesTemplateBrowseBtn;

    public VuexSettingsForm(VuexCreateOptions options) {
        super(options);

        if (!options.isIndexTemplateDefault()) {
            indexTemplateInput.setText(options.getIndexFile());
        }

        if (!options.isActionsTemplateDefault()) {
            actionsTemplateInput.setText(options.getActionFile());
        }

        if (!options.isGettersTemplateDefault()) {
            gettersTemplateInput.setText(options.getGettersFile());
        }

        if (!options.isMutationTemplateDefault()) {
            mutationsTemplateInput.setText(options.getMutationsFile());
        }

        if (!options.isStateTemplateDefault()) {
            stateTemplateInput.setText(options.getStateFile());
        }

        if (!options.isTypesTemplateDefault()) {
            typesTemplateInput.setText(options.getTypesFile());
        }

        indexTemplateBrowseBtn.addActionListener(e -> onBrowseButtonClicked(e, indexTemplateInput));
        actionsTemplateBrowseBtn.addActionListener(e -> onBrowseButtonClicked(e, actionsTemplateInput));
        gettersTemplateBrowseBtn.addActionListener(e -> onBrowseButtonClicked(e, gettersTemplateInput));
        mutationsTemplateBrowseBtn.addActionListener(e -> onBrowseButtonClicked(e, mutationsTemplateInput));
        stateTemplateBrowseBtn.addActionListener(e -> onBrowseButtonClicked(e, stateTemplateInput));
        typesTemplateBrowseBtn.addActionListener(e -> onBrowseButtonClicked(e, typesTemplateInput));
    }

    @Override
    public JComponent getMainPanel() {
        return mainPanel;
    }

    @Override
    public boolean isDirty() {
        VuexCreateOptions o = new VuexCreateOptions();
        applySettings(o);
        return !options.equals(o);
    }

    @Override
    public void applySettings(VuexCreateOptions options) {
        options.setIndexFile(indexTemplateInput.getText());
        options.setActionFile(actionsTemplateInput.getText());
        options.setGettersFile(gettersTemplateInput.getText());
        options.setMutationsFile(mutationsTemplateInput.getText());
        options.setStateFile(stateTemplateInput.getText());
        options.setTypesFile(typesTemplateInput.getText());
    }
}
