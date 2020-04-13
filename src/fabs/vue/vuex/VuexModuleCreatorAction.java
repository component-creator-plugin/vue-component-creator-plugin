package fabs.vue.vuex;

import com.intellij.openapi.project.Project;
import fabs.util.AbstractCreatorAction;
import fabs.util.AbstractDialog;
import fabs.vue.vuex.data.VuexCreateOptions;

public class VuexModuleCreatorAction extends AbstractCreatorAction {

    @Override
    protected AbstractDialog createDialog(Project project) {
        return new VuexCreatorDialog(new VuexCreateOptions());
    }
}
