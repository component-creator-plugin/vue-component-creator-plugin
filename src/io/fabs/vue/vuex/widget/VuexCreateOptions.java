package io.fabs.vue.vuex.widget;

import io.fabs.util.AbstractOptions;
import io.fabs.util.StringFormatter;
import io.fabs.util.TemplateUtils;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.Map;

public class VuexCreateOptions extends AbstractOptions {
    public static final String STORE_KEY = "vcc.vuex";

    private final String ACTION_FILE_KEY = "ACTION_FILE";
    private final String INDEX_FILE_KEY = "INDEX_FILE_KEY";
    private final String GETTERS_FILE_KEY = "GETTERS_FILE_KEY";
    private final String MUTATIONS_FILE_KEY = "MUTATIONS_FILE_KEY";
    private final String MUTATION_TYPES_FILE_KEY = "MUTATION_TYPES_FILE_KEY";
    private final String STATE_FILE_KEY = "STATE_FILE_KEY";
    private final String TYPES_FILE_KEY = "TYPES_FILE_KEY";

    private final String defaultActionFile = "templates/vuex/actions.js";
    private final String defaultIndexFile = "templates/vuex/index.js";
    private final String defaultGettersFile = "templates/vuex/getters.js";
    private final String defaultMutationsFile = "templates/vuex/mutations.js";
    private final String defaultMutationTypesFile = "templates/vuex/mutation-types.js";
    private final String defaultStateFile = "templates/vuex/state.js";
    private final String defaultTypesFile = "templates/vuex/types.d.ts";

    private String actionFile = defaultActionFile;
    private String indexFile = defaultIndexFile;
    private String gettersFile = defaultGettersFile;
    private String mutationsFile = defaultMutationsFile;
    private String mutationTypesFile = defaultMutationTypesFile;
    private String stateFile = defaultStateFile;
    private String typesFile = defaultTypesFile;

    private Boolean isCreateGetters = false;
    private Boolean isCreateTypes = false;
    private Boolean isCreateMutationTypes = false;

    private String moduleName;
    private String mutationTypesFilePath;
    private String propertyName;
    private String getterName;
    private String propertyType;


    @Override
    public ArrayList<String> getFiles() {

        ArrayList<String> files = new ArrayList<String>();

        files.add(actionFile);
        files.add(stateFile);
        files.add(indexFile);
        files.add(mutationsFile);

        if (isCreateGetters) {
            files.add(gettersFile);
        }

        if (isCreateTypes) {
            files.add(typesFile);
        }

        if (isCreateMutationTypes) {
            files.add(mutationTypesFile);
        }

        return files;
    }

    @Override
    public Map<String, String> getTemplateVariables() {
        Map<String, String> templateModel = TemplateUtils.createVariableMap(moduleName);

        templateModel.put("mutationsFile", mutationTypesFilePath);
        templateModel.put("property", propertyName);
        templateModel.put("getterName", getterName);
        templateModel.put("propertyType", propertyType);

        templateModel.put("getters", isCreateGetters ? "1" : "0");
        templateModel.put("useInterface", isCreateTypes ? "1" : "0");
        templateModel.put("createMutationTypes", isCreateMutationTypes ? "1" : "0");

        templateModel.put("actionName", "set".concat(StringFormatter.capitalizeFirst(propertyName)));
        templateModel.put("mutationName", "SET_".concat(propertyName.toUpperCase()));
        templateModel.put("tsInterfaceName", StringFormatter.toPascalCase(moduleName).concat("State"));
        return templateModel;
    }

    @Override
    public Element serialize() {
        final Element element = new Element(STORE_KEY);
        element.setAttribute(ACTION_FILE_KEY, actionFile);
        element.setAttribute(INDEX_FILE_KEY, indexFile);
        element.setAttribute(GETTERS_FILE_KEY, gettersFile);
        element.setAttribute(MUTATIONS_FILE_KEY, mutationsFile);
        element.setAttribute(MUTATION_TYPES_FILE_KEY, mutationTypesFile);
        element.setAttribute(STATE_FILE_KEY, stateFile);
        element.setAttribute(TYPES_FILE_KEY, typesFile);
        return element;
    }

    @Override
    public void deserialize(Element element) {
        setActionFile(element.getAttributeValue(ACTION_FILE_KEY));
        setIndexFile(element.getAttributeValue(INDEX_FILE_KEY));
        setGettersFile(element.getAttributeValue(GETTERS_FILE_KEY));
        setMutationsFile(element.getAttributeValue(MUTATIONS_FILE_KEY));
        setMutationTypesFile(element.getAttributeValue(MUTATION_TYPES_FILE_KEY));
        setStateFile(element.getAttributeValue(STATE_FILE_KEY));
        setTypesFile(element.getAttributeValue(TYPES_FILE_KEY));

    }

    public boolean isActionsTemplateDefault() {
        return actionFile.equals(defaultActionFile);
    }

    public boolean isIndexTemplateDefault() {
        return indexFile.equals(defaultIndexFile);
    }

    public boolean isGettersTemplateDefault() {
        return gettersFile.equals(defaultGettersFile);
    }

    public boolean isMutationTemplateDefault() {
        return mutationsFile.equals(defaultMutationsFile);
    }

    public boolean isMutationTypesTemplateDefault() {
        return mutationTypesFile.equals(defaultMutationTypesFile);
    }

    public boolean isStateTemplateDefault() {
        return stateFile.equals(defaultStateFile);
    }

    public boolean isTypesTemplateDefault() {
        return typesFile.equals(defaultTypesFile);
    }

    public String getActionFile() {
        return actionFile;
    }

    public void setActionFile(String actionFile) {
        this.actionFile = actionFile == null || actionFile.isEmpty() ? defaultActionFile : actionFile;
    }

    public String getIndexFile() {
        return indexFile;
    }

    public void setIndexFile(String indexFile) {
        this.indexFile = indexFile == null || indexFile.isEmpty() ? defaultIndexFile : indexFile;
    }

    public String getGettersFile() {
        return gettersFile;
    }

    public void setGettersFile(String gettersFile) {
        this.gettersFile = gettersFile == null || gettersFile.isEmpty() ? defaultGettersFile : gettersFile;
    }

    public String getMutationsFile() {
        return mutationsFile;
    }

    public void setMutationsFile(String mutationsFile) {
        this.mutationsFile = mutationsFile == null || mutationsFile.isEmpty() ? defaultMutationsFile : mutationsFile;
    }

    public String getMutationTypesFile() {
        return mutationTypesFile;
    }

    public void setMutationTypesFile(String mutationTypesFile) {
        this.mutationTypesFile = mutationTypesFile == null || mutationTypesFile.isEmpty() ? defaultMutationTypesFile : mutationTypesFile;
    }

    public String getStateFile() {
        return stateFile;
    }

    public void setStateFile(String stateFile) {
        this.stateFile = stateFile == null || stateFile.isEmpty() ? defaultStateFile : stateFile;
    }

    public String getTypesFile() {
        return typesFile;
    }

    public void setTypesFile(String typesFile) {
        this.typesFile = typesFile == null || typesFile.isEmpty() ? defaultTypesFile : typesFile;
    }

    public Boolean getCreateGetters() {
        return isCreateGetters;
    }

    public void setCreateGetters(Boolean createGetters) {
        this.isCreateGetters = createGetters;
    }

    public Boolean getCreateTypes() {
        return isCreateTypes;
    }

    public void setCreateTypes(Boolean createTypes) {
        isCreateTypes = createTypes;
    }

    public Boolean getCreateMutationTypes() {
        return isCreateMutationTypes;
    }

    public void setCreateMutationTypes(Boolean createMutationTypes) {
        isCreateMutationTypes = createMutationTypes;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getMutationTypesFilePath() {
        return mutationTypesFilePath;
    }

    public void setMutationTypesFilePath(String mutationTypesFilePath) {
        this.mutationTypesFilePath = mutationTypesFilePath;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getGetterName() {
        return getterName;
    }

    public void setGetterName(String getterName) {
        this.getterName = getterName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}
