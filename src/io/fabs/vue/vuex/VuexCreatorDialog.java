package io.fabs.vue.vuex;

import io.fabs.util.AbstractDialog;
import io.fabs.vue.vuex.data.VuexCreateOptions;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VuexCreatorDialog extends AbstractDialog<VuexCreateOptions> {
    private JPanel contentPane;
    private JTextField moduleNameTextField;
    private JButton btnOk;
    private JCheckBox gettersCheckBox;
    private JTextField mutationTypesTextField;
    private JTextField propertyNameTextField;
    private JTextField getterNameTextField;
    private JCheckBox mutationTypesCheckBox;
    private JTextField propertyTypeTextField;
    private JCheckBox stateInterfaceCheckBox;

    public VuexCreatorDialog(VuexCreateOptions opts) {
        super(opts);
        setContentPane(contentPane);
        getRootPane().setDefaultButton(btnOk);

        btnOk.addActionListener(e -> onOK());

        // call onCancel() when cross is clicked
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public String getComponentName() {
        return moduleNameTextField.getText();
    }

    @Override
    public String getDirectoryName() {
        return moduleNameTextField.getText();
    }

    @Override
    public VuexCreateOptions setOptions(VuexCreateOptions options) {
        options.setModuleName(moduleNameTextField.getText());
        options.setMutationTypesFilePath(mutationTypesTextField.getText());
        options.setPropertyName(propertyNameTextField.getText());
        options.setGetterName(getterNameTextField.getText());
        options.setPropertyType(propertyTypeTextField.getText());

        options.setCreateGetters(gettersCheckBox.isSelected());
        options.setCreateMutationTypes(mutationTypesCheckBox.isSelected());
        options.setCreateTypes(stateInterfaceCheckBox.isSelected());

        return options;
    }

}
