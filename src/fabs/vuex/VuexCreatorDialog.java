package fabs.vuex;

import fabs.util.AbstractDialog;
import fabs.util.StringFormatter;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VuexCreatorDialog extends AbstractDialog {
    private JPanel contentPane;
    private JTextField moduleNameTextField;
    private JButton btnOk;
    private JButton btnCancel;
    private JCheckBox gettersCheckBox;
    private JTextField mutationTypesTextField;
    private JTextField mutationNameTextField;
    private JTextField actionNameTextField;
    private JTextField propertyNameTextField;
    private JTextField getterNameTextField;
    private JCheckBox mutationTypesCheckBox;
    private JTextField propertyTypeTextField;
    private JCheckBox stateInterfaceCheckBox;


    public final String ACTION_FILE = "templates/vuex/actions.js.mustache";
    public final String INDEX_FILE = "templates/vuex/index.js.mustache";
    public final String GETTERS_FILE = "templates/vuex/getters.js.mustache";
    public final String STATE_INTERFACE = "templates/vuex/types.d.ts.mustache";
    public final String STATE_FILE = "templates/vuex/state.js.mustache";
    public final String MUTATIONS_FILE = "templates/vuex/mutations.js.mustache";
    public final String MUTATIONTYPES_FILE = "templates/vuex/mutation-types.js.mustache";

    public VuexCreatorDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOk);

        btnOk.addActionListener(e -> onOK());

        btnCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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
    public String[] getFiles() {
        ArrayList<String> files = new ArrayList<String>();

        files.add(ACTION_FILE);
        files.add(STATE_FILE);
        files.add(INDEX_FILE);
        files.add(MUTATIONS_FILE);

        if (gettersCheckBox.isSelected()) {
            files.add(GETTERS_FILE);
        }
        if (stateInterfaceCheckBox.isSelected()) {
            files.add(STATE_INTERFACE);
        }

        if (mutationTypesCheckBox.isSelected()) {
            files.add(MUTATIONTYPES_FILE);
        }

        return files.toArray(new String[files.size()]);

    }

    public Map<String, Object> getTemplateVars() {
        Map<String, Object> templateModel = new HashMap<String, Object>();
        String moduleName = moduleNameTextField.getText();

        templateModel.put("componentName", moduleName);
        templateModel.put("mutationName", mutationNameTextField.getText());
        templateModel.put("mutationsFile", mutationTypesTextField.getText());
        templateModel.put("actionName", actionNameTextField.getText());
        templateModel.put("property", propertyNameTextField.getText());
        templateModel.put("getterName", getterNameTextField.getText());
        templateModel.put("tsInterfaceName", StringFormatter.toSnakeCase(moduleName).concat("State"));
        templateModel.put("propertyType", propertyTypeTextField.getText());

        templateModel.put("getters", gettersCheckBox.isSelected());
        templateModel.put("useInterface", stateInterfaceCheckBox.isSelected());
        return templateModel;
    }
}
