import { %MUTATION_NAME% } from '%MUTATION_FILE%';

export function set({ commit }, { data }) {
    commit(%MUTATION_NAME%, { data });
}
