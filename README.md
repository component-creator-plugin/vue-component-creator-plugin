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

- componentName
  - _component-name.scss
  - component-name.md
  - component-name.vue
  - component-name.stories.js
  - component-name.spec.js


## Vuex module
<img src="https://github.com/component-creator-plugin/vue-component-creator-plugin/raw/master/doc/new-vuex.png"/>

By creating a new Vuex module, a couple of files will be generated.

__Structure__

- moduleName
    - actions.js
    - index.js
    - mutations.js
    - state.js
    - mutation-types.js (depending whether you set the `Mutationstypes File`
    - getters.js (depending wether you checked `Getters File`
    - types.d.ts



## Customize Templates
### Component

Available template variables

Variable | Example | Description
---|---|---
componentName | `my-module` | Name of the component
componentNameCamelCase | `myModule` | Name of the component in camelCase
componentNamePascalCase | `MyModule` | Name of the component in camelCase
createMarkdown | `0`/`1` | Whether the markdown file is created or not


### Vuex
Available template variables

Variable | Example | Description
---|---|---
componentName | `my-module` | Name of the component
componentNameCamelCase | `myModule` | Name of the component in camelCase
componentNamePascalCase | `MyModule` | Name of the component in camelCase
mutationsFile | `./mutation-types.js` | Filepath to the mutations
property | `data` | Name of the property to be created
getterName | `getData` | Getter function name
propertyType | `string` | Type of the property
getters | `0`/`1` | Create getters
useInterface | `0`/`1` | Create a typescript file with type definitions
createMutationTypes | `0`/`1` | Whether to create a custom mutation types file
actionName | `setData` | Name of the action
mutationName | `SET_DATA` | Name of the mutation type
tsInterfaceName | `MyModuleState` | Name of the TypeScript State interface name



## Development
Checkout the [Development Setup Guide](./doc/DEVELOPMENT.md) for the setup.

## Icons
Icons provided by https://www.iconfinder.com/justicon via https://www.iconfinder.com
