package fabs.util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public abstract class AbstractDialog extends JDialog {

    protected abstract ArrayList<String> getFiles();

    public abstract Map<String, Object> getTemplateVars();

    public abstract String getComponentName();
    public abstract String getDirectoryName();

    protected boolean hasCanceled = false;

    public String[] getFileList() {
        ArrayList<String> files = getFiles();
        return files.toArray(new String[files.size()]);
    }

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
