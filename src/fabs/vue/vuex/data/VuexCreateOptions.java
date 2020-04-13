package fabs.vue.vuex.data;

import fabs.util.AbstractOptions;
import fabs.util.StringFormatter;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VuexCreateOptions extends AbstractOptions {
    public static final String STORE_KEY = "vcc.vuex";

    private final String defaultActionFile = "templates/vuex/actions.js.mustache";
    private final String defaultIndexFile = "templates/vuex/index.js.mustache";
    private final String defaultGettersFile = "templates/vuex/getters.js.mustache";
    private final String defaultMutationsFile = "templates/vuex/mutations.js.mustache";
    private final String defaultMutationTypesFile = "templates/vuex/mutation-types.js.mustache";
    private final String defaultStateFile = "templates/vuex/state.js.mustache";
    private final String defaultTypesFile = "templates/vuex/types.d.ts.mustache";

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
    private String mutationName;
    private String actionName;
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
    public Map<String, Object> getTemplateVariables() {
        Map<String, Object> templateModel = new HashMap<String, Object>();

        templateModel.put("componentName", moduleName);
        templateModel.put("mutationName", mutationName);

        templateModel.put("mutationsFile", mutationTypesFilePath);
        templateModel.put("actionName", actionName);
        templateModel.put("property", propertyName);
        templateModel.put("getterName", getterName);
        templateModel.put("propertyType", propertyType);

        templateModel.put("getters", isCreateGetters);
        templateModel.put("useInterface", isCreateTypes);

        templateModel.put("tsInterfaceName", StringFormatter.toSnakeCase(moduleName).concat("State"));
        return templateModel;
    }

    @Override
    public Element serialize() {
        return null;
    }

    @Override
    public void deserialize(Element element) {

    }

    public String getActionFile() {
        return actionFile;
    }

    public void setActionFile(String actionFile) {
        this.actionFile = actionFile;
    }

    public String getIndexFile() {
        return indexFile;
    }

    public void setIndexFile(String indexFile) {
        this.indexFile = indexFile;
    }

    public String getGettersFile() {
        return gettersFile;
    }

    public void setGettersFile(String gettersFile) {
        this.gettersFile = gettersFile;
    }

    public String getMutationsFile() {
        return mutationsFile;
    }

    public void setMutationsFile(String mutationsFile) {
        this.mutationsFile = mutationsFile;
    }

    public String getMutationTypesFile() {
        return mutationTypesFile;
    }

    public void setMutationTypesFile(String mutationTypesFile) {
        this.mutationTypesFile = mutationTypesFile;
    }

    public String getStateFile() {
        return stateFile;
    }

    public void setStateFile(String stateFile) {
        this.stateFile = stateFile;
    }

    public String getTypesFile() {
        return typesFile;
    }

    public void setTypesFile(String typesFile) {
        this.typesFile = typesFile;
    }

    public Boolean getCreateGetters() {
        return isCreateGetters;
    }

    public void setCreateGetters(Boolean createGetters) {
        isCreateGetters = createGetters;
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

    public String getMutationName() {
        return mutationName;
    }

    public void setMutationName(String mutationName) {
        this.mutationName = mutationName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
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
