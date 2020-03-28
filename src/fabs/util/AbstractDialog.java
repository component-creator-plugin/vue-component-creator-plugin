package fabs.util;

import javax.swing.*;
import java.util.Map;

public abstract class AbstractDialog extends JDialog {

    public abstract String[] getFiles();

    public abstract Map<String, Object> getTemplateVars();

    public abstract String getComponentName();

    protected boolean hasCanceled = false;

    public boolean isCanceled() {
        return hasCanceled;
    }

    protected void onOK() {
        hasCanceled = false;
        dispose();
    }

    protected void onCancel() {
        hasCanceled = true;
        dispose();
    }
}
