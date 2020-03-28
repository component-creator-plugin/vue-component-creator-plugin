package fabs.vuex;

import fabs.util.AbstractCreatorAction;
import fabs.util.AbstractDialog;

public class VuexModuleCreatorAction extends AbstractCreatorAction {

    @Override
    protected AbstractDialog createDialog() {
        return new VuexCreatorDialog();
    }
}
