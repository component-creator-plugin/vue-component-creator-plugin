# vue-component-creator
An Brainstorm Plugin to create single file vue.js components with a Sass file along them and complete vuex modules.
This plugins does a couple of things in order to simplify your dev experience.

![Create component](./doc/create-component.gif "")
![Create component](./doc/create-vuex.gif "")

# Install
Search for `Vue Component Creator` in the plugins settings. Or download the plugin from the [release site](https://github.com/faebeee/vue-component-creator-plugin/releases)

<img src="https://github.com/faebeee/vue-component-creator-plugin/raw/master/doc/install.png"/>


## Vue single file component
Right click in the project tree view where you want to place the new module. Then `New File` -> `Vue Module`.
This will open a dialog to define the module's name. This name is used later
to name the directory, vue- and sass-file as well as the sass root name, and a root node in the vue file
with the given name.

<img src="https://github.com/faebeee/vue-component-creator-plugin/raw/master/doc/new-component.png"/>

__Example__

- my-module
  - my-module.vue
  - _my-module.scss


File: my-module.vue

```vue
    <template>
        <div class="my-module">
            <pre v-text="$attrs"/>
        </div>
    </template>

    <script>
        export default {
            props: {
            },
        };
    </script>
    
    <style lang="scss">
        @import "my-module";
    </style>

```

File: _my-module.scss

```scss
    .my-module {
        // Vars

        // Support

        // Module
        & {
            //
        }

        // Facets

        // States
    }
```



## Vuex module
<img src="https://github.com/faebeee/vue-component-creator-plugin/raw/master/doc/new-vuex.png"/>

By creating a new Vuex module, a couple of files will be generated.

- name
    - actions.js
    - index.js
    - mutations.js
    - state.js
    - mutation-types.js (depending whether you set the `Mutationstypes File`
    - getters.js (depending wether you checked `Getters File`

### Files

__actions.js__
This file contains all the actions available

__index.js__
Default entrypoint to load the vuex module

__mutations.js__
Performs all mutations on the vuex state

__state.js__
Holds the initial state

__mutation-types.js__
Exports all mutation types that can be used in `actions.js` and `mutations.js`.
This file is only generated, if you leave the field `Mutationstypes File` empty
in the dialog.

__getters.js__
Exports all the available getters. This is only created, if the `Getters File` field
is checked.

__types.d.ts__
Export an interface representing the state data structure. Depends on the `Files State Interface` Checkbox

### Options

__Module Name__
The name of the vuex submodule

__Mutation Name__
The first mutation name

__Action Name__
Name of the action, triggering a mutation with the `Mutation Name`

__Mutationtypes File__
Where to load the `Mutation Name` from. All mutations are stored within the
same file.

__Files - Getters File__
Whether to create a getterfile or not


## Icons
Icons provided by https://www.iconfinder.com/justicon via https://www.iconfinder.com
