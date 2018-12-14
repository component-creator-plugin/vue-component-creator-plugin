import * as types from './mutation-types';

export function set({ commit }, { data }) {
    commit(types.MUTATION, { data });
}
