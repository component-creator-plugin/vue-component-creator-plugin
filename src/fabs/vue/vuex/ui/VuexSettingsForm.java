package fabs.vue.vuex.ui;

import fabs.util.AbstractSettingsForm;
import fabs.vue.vuex.data.VuexCreateOptions;

import javax.swing.*;

public class VuexSettingsForm extends AbstractSettingsForm<VuexCreateOptions> {

    public VuexSettingsForm(VuexCreateOptions options) {
        super(options);
    }

    @Override
    public JComponent getMainPanel() {
        return null;
    }

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public void applySettings(VuexCreateOptions options) {

    }
}
