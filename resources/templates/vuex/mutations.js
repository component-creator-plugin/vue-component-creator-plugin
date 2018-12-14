import * as types from './mutation-types';

export default {
    [types.MUTATION](state, { data }) {
        state.data = data;
    },
};
