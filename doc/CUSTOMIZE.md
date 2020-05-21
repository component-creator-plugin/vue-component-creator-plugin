# Component

Available variables

Variable | Type | Description
---|---|---
componentName | `string` | Name of the component
componentNameCamelCase | `string` | Name of the component in camelCase

##  {{componentName}}.vue.mustache
    <template>
        <div class="{{ componentName }}">
            <pre v-text="$attrs"/>
        </div>
    </template>
    
    <script>
        export default {
            props: {
            },
        };
    </script>



##  _{{componentName}}.scss.mustache
    .{{ componentName }} {
        // Vars
    
        // Support
    
        // Module
        & {
            //
        }
    
        // Facets
    
        // States
    }

# Vuex
Available variables

Variable | Type | Description
---|---|---
componentName | `string` |Name of the vuex module
mutationsFile | `string` | Filepath to the mutations
property | `string` | Name of the property to be created
getterName | `string` | Getter function name
propertyType | `string` | Type of the property
getters | `boolean` | Create getters
useInterface | `boolean` | Create a typescript file with type definitions
createMutationTypes | `boolean` | Wether to create a custom mutation types file
actionName | `string` | Name of the action
mutationName | `string` | Name of the mutation type
tsInterfaceName | `string` | Name of the TypeScript State interface name


## actions.js.mustache

    import { {{ mutationName }} } from '{{ mutationsFile }}';
    
    /**
    *
    * @param { function } commit
    * @param { {{propertyType}} } {{property}}
    */
    export function {{ actionName }}({ commit }, { {{ property }} }) {
        commit({{ mutationName }}, { {{ property }} });
    }

## getters.js.mustache

    /**
    *
    * {{# useInterface }}
    * @param { {{tsInterfaceName}} } state
    {{/ useInterface }}
     {{ ^useInterface }}
    * @param { {{object}} } state
    {{/ useInterface }}
    * @return { {{ propertyType }} }
    */
    export function {{getterName}}(state) {
        return state.{{ property }};
    }

## index.js.mustache

    import * as actions from './actions';
    import mutations from './mutations';
    {{# getters }}
    import * as getters from './getters';
    {{/ getters }}
    import state from './state';
    
    export default {
        namespaced: true,
        mutations,
        actions,
        state,
        {{# getters }}
        getters,
        {{/ getters }}
    };

## mutation-types.js.mustache

    export const { {{ mutationName }} } = '{{ componentName }}/{{ mutationName }}';

## mutations.js.mustache

    import { {{ mutationName }} } from '{{ mutationsFile }}';
    
    export default {
        /**
        *
        {{# useInterface }}
        * @param { {{tsInterfaceName}} } state
        {{/ useInterface }}
         {{ ^useInterface }}
        * @param { object } state
        {{/ useInterface }}
        * @param { {{propertyType}} } {{property}}
        */
        [{{ mutationName }}](state, { {{ property }} }) {
            state.{{ property }} = {{ property }};
        },
    };

## state.js.mustache

    {{# useInterface }}
    /** @var { {{tsInterfaceName}} } */
    {{/ useInterface }}
    const STATE = {
        {{ property }}: null,
    };
    
    export default STATE;

## types.d.ts.mustache

    export interface {{ tsInterfaceName }} {
        {{ property }}: {{ propertyType }};
    }


