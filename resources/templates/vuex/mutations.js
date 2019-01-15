import { %MUTATION_NAME% } from '%MUTATION_FILE%';

export default {
    [%MUTATION_NAME%](state, { data }) {
        state.data = data;
    },
};
