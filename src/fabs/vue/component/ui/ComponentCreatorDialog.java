package fabs.vue.component.ui;

import io.fabs.util.AbstractDialog;
import fabs.vue.component.data.ComponentCreateOptions;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ComponentCreatorDialog extends AbstractDialog<ComponentCreateOptions> {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField componentNameTextField;
    private JCheckBox storybookFileCheckbox;
    private JCheckBox scssFileCheckbox;
    private JCheckBox specFileCheckbox;

    public ComponentCreatorDialog(ComponentCreateOptions opt) {
        super(opt);
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    public String getComponentName() {
        return componentNameTextField.getText();
    }

    @Override
    public String getDirectoryName() {
        return componentNameTextField.getText();
    }

    @Override
    public ComponentCreateOptions setOptions(ComponentCreateOptions options) {
        options.setComponentName(componentNameTextField.getText());
        options.setCreateSassFile(scssFileCheckbox.isSelected());
        options.setCreateStorybookFile(storybookFileCheckbox.isSelected());
        options.setCreateSpecFile(specFileCheckbox.isSelected());
        return options;
    }
}
