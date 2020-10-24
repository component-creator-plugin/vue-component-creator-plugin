# vue-component-creator

![Downloads](https://img.shields.io/jetbrains/plugin/d/11443-vue-component-creator?style=for-the-badge)
![Version](https://img.shields.io/jetbrains/plugin/v/11443-vue-component-creator?style=for-the-badge)
![Rating](https://img.shields.io/jetbrains/plugin/r/rating/11443-vue-component-creator?style=for-the-badge)

An Brainstorm Plugin to create single file vue.js components with a Sass file along them and complete vuex modules.
This plugins does a couple of things in order to simplify your dev experience.

![Create Component](https://github.com/component-creator-plugin/vue-component-creator-plugin/raw/master/doc/create-component.gif)
![Create Vuex Module](https://github.com/component-creator-plugin/vue-component-creator-plugin/raw/master/doc/create-vuex.gif)

## Install
Search for `Vue Component Creator` in the plugins settings. Or download the plugin from the [release site](https://github.com/faebeee/vue-component-creator-plugin/releases)

![Plugin Installation](https://github.com/component-creator-plugin/vue-component-creator-plugin/raw/master/doc/install.png)

## Vue single file component
Right click in the project tree view where you want to place the new module. Then `New File` -> `Vue Module`.
This will open a dialog to define the module's name. This name is used later
to name the directory, vue- and sass-file as well as the sass root name, and a root node in the vue file
with the given name.

![New Component](https://github.com/component-creator-plugin/vue-component-creator-plugin/raw/master/doc/new-component.png)

__Structure__

- my-module
  - my-module.vue
  - _my-module.scss
  - _my-module.story.js
  - _my-module.spec.js


## Vuex module
<img src="https://github.com/component-creator-plugin/vue-component-creator-plugin/raw/master/doc/new-vuex.png"/>

By creating a new Vuex module, a couple of files will be generated.

__Structure__

- name
    - actions.js
    - index.js
    - mutations.js
    - state.js
    - mutation-types.js (depending whether you set the `Mutationstypes File`
    - getters.js (depending wether you checked `Getters File`
    - types.d.ts



## Customize Templates
### Component

Available variables

Variable | Example | Description
---|---|---
componentName | `my-module` | Name of the component
componentNameCamelCase | `myModule` | Name of the component in camelCase
componentNamePascalCase | `MyModule` | Name of the component in camelCase

####  {{componentName}}.vue.mustache
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



####  _{{componentName}}.scss.mustache
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

### Vuex
Available variables

Variable | Type | Description
---|---|---
componentName | `my-module` | Name of the component
componentNameCamelCase | `myModule` | Name of the component in camelCase
componentNamePascalCase | `MyModule` | Name of the component in camelCase
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


#### actions.js.mustache

    import { {{ mutationName }} } from '{{ mutationsFile }}';
    
    /**
    *
    * @param { function } commit
    * @param { {{propertyType}} } {{property}}
    */
    export function {{ actionName }}({ commit }, { {{ property }} }) {
        commit({{ mutationName }}, { {{ property }} });
    }

#### getters.js.mustache

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

#### index.js.mustache

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

#### mutation-types.js.mustache

    export const { {{ mutationName }} } = '{{ componentName }}/{{ mutationName }}';

#### mutations.js.mustache

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

#### state.js.mustache

    {{# useInterface }}
    /** @var { {{tsInterfaceName}} } */
    {{/ useInterface }}
    const STATE = {
        {{ property }}: null,
    };
    
    export default STATE;

#### types.d.ts.mustache

    export interface {{ tsInterfaceName }} {
        {{ property }}: {{ propertyType }};
    }

## Development
Checkout the [Development Setup Guide](./doc/DEVELOPMENT.md) for the setup.

## Icons
Icons provided by https://www.iconfinder.com/justicon via https://www.iconfinder.com
