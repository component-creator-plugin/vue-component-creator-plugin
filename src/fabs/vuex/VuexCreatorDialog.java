package fabs.vuex;

import org.fest.util.Maps;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;

public class VuexCreatorDialog extends JDialog {
    private JPanel contentPane;
    private JTextField moduleNameTextField;
    private JButton btnOk;
    private JButton btnCancel;
    private JCheckBox gettersCheckBox;
    private JTextField mutationTypesTextField;
    private JLabel mutationtypeFileLabel;
    private JTextField mutationNameTextField;
    private JTextField actionNameTextField;


    public final String ACTION_FILE = "templates/vuex/actions.js.mustache";
    public final String INDEX_FILE = "templates/vuex/index.js.mustache";
    public final String GETTERS_FILE = "templates/vuex/getters.js.mustache";
    public final String STATE_FILE = "templates/vuex/state.js.mustache";
    public final String MUTATIONS_FILE = "templates/vuex/mutations.js.mustache";
    public final String MUTATIONTYPES_FILE = "templates/vuex/mutation-types.js.mustache";

    private boolean hasCanceled = false;

    public VuexCreatorDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOk);

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
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

    public String getComponentName() {
        return moduleNameTextField.getText();
    }

    public String[] getListOfFilesToCopy() {
        ArrayList<String> files = new ArrayList<String>();

        files.add(ACTION_FILE);
        files.add(STATE_FILE);
        files.add(INDEX_FILE);
        files.add(MUTATIONS_FILE);

        if(mutationTypesTextField.getText().length() == 0) {
            files.add(MUTATIONTYPES_FILE);
        }

        if (gettersCheckBox.isSelected()) {
            files.add(GETTERS_FILE);
        }

        return files.toArray(new String[files.size()]);

    }

    public Map<String, Object> getTemplateVars(){
         Map<String, Object> templateModel = Maps.newHashMap();
        templateModel.put("componentName", moduleNameTextField.getText());
        templateModel.put("mutationName", mutationNameTextField.getText());
        templateModel.put("mutationsFile", mutationTypesTextField.getText());
        templateModel.put("getters", gettersCheckBox.isSelected());
        templateModel.put("actionName", actionNameTextField.getText());
        return templateModel;
    }

    public String getMutationName(){
        return mutationNameTextField.getText();
    }

    public String getMutationFilePathForTemplate(){
        if(mutationTypesTextField.getText().length() == 0){
            return "./mutation-types.js.mustache";
        }

        return mutationTypesTextField.getText();
    }

    public boolean isCanceled() {
        return hasCanceled;
    }

    private void onOK() {
        hasCanceled = false;
        dispose();
    }

    private void onCancel() {
        hasCanceled = true;
        dispose();
    }
}
