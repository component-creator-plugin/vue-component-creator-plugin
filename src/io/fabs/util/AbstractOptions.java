package io.fabs.util;

import io.fabs.util.settings.SerializableOptions;

import java.util.ArrayList;
import java.util.Map;

public abstract class AbstractOptions implements SerializableOptions {
    abstract public ArrayList<String> getFiles();

    abstract public Map<String, String> getTemplateVariables();

    public String[] getFileList() {
        return getFiles().toArray(new String[getFiles().size()]);
    }
}
