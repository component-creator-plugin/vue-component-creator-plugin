package fabs.component;

import fabs.util.AbstractDialog;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComponentCreatorDialog extends AbstractDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField componentNameTextField;

    private final String vueTemplateFile = "templates/component/component.vue.mustache";
    private final String sassTemplateFile = "templates/component/_component.scss.mustache";

    public ComponentCreatorDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    @Override
    public String[] getFiles() {
        ArrayList<String> files = new ArrayList<String>();
        files.add(vueTemplateFile);
        files.add(sassTemplateFile);

        return files.toArray(new String[files.size()]);
    }

    public Map<String, Object> getTemplateVars() {
        Map<String, Object> templateModel = new HashMap<String, Object>();
        templateModel.put("componentName", componentNameTextField.getText());
        return templateModel;
    }

    public String getComponentName() {
        return componentNameTextField.getText();
    }


}
