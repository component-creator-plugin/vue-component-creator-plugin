import * as actions from './actions';
import mutations from './mutations';
import getters from './getters';
import store from './store';

export default {
    namespaced: true,
    mutations,
    actions,
    state,
};
