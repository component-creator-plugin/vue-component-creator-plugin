package io.fabs.util;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class AbstractDialog<T extends AbstractOptions> extends JDialog {
    protected T options;

    public AbstractDialog(T options) {
        super();
        this.options = options;

        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
    }

    public abstract String getComponentName();

    public abstract String getDirectoryName();

    public abstract T setOptions(T options);

    protected boolean hasCanceled = false;

    public boolean isCanceled() {
        return hasCanceled;
    }

    protected void onOK() {
        hasCanceled = false;
        dispose();
        this.options = setOptions(this.options);
    }

    protected void onCancel() {
        hasCanceled = true;
        dispose();
    }

    public T getOptions() {
        return options;
    }
}
