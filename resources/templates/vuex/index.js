import * as actions from './actions';
import mutations from './mutations';
import getters from './getters';
import state from './state';

export default {
    namespaced: true,
    mutations,
    actions,
    state,
};
