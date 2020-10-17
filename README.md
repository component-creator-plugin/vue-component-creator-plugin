# vue-component-creator

![Downloads](https://img.shields.io/jetbrains/plugin/d/11443-vue-component-creator?style=for-the-badge)
![Version](https://img.shields.io/jetbrains/plugin/v/11443-vue-component-creator?style=for-the-badge)
![Rating](https://img.shields.io/jetbrains/plugin/r/rating/11443-vue-component-creator?style=for-the-badge)

An Brainstorm Plugin to create single file vue.js components with a Sass file along them and complete vuex modules.
This plugins does a couple of things in order to simplify your dev experience.

<img src="https://github.com/faebeee/vue-component-creator-plugin/raw/master/doc/create-component.gif"/>
<img src="https://github.com/faebeee/vue-component-creator-plugin/raw/master/doc/create-vuex.gif"/>

## Install
Search for `Vue Component Creator` in the plugins settings. Or download the plugin from the [release site](https://github.com/faebeee/vue-component-creator-plugin/releases)

<img src="https://github.com/faebeee/vue-component-creator-plugin/raw/master/doc/install.png"/>


## Customize Templates
In the settings you can define custom templates to use.
Read [here](./doc/CUSTOMIZE.md) to learn what the default templates look like
and what variables are available for your custom templates


## Vue single file component
Right click in the project tree view where you want to place the new module. Then `New File` -> `Vue Module`.
This will open a dialog to define the module's name. This name is used later
to name the directory, vue- and sass-file as well as the sass root name, and a root node in the vue file
with the given name.

<img src="https://github.com/faebeee/vue-component-creator-plugin/raw/master/doc/new-component.png"/>

__Structure__

- my-module
  - my-module.vue
  - _my-module.scss
  - _my-module.story.js
  - _my-module.spec.js


## Vuex module
<img src="https://github.com/faebeee/vue-component-creator-plugin/raw/master/doc/new-vuex.png"/>

By creating a new Vuex module, a couple of files will be generated.

__Structure__

- name
    - actions.js
    - index.js
    - mutations.js
    - state.js
    - mutation-types.js (depending whether you set the `Mutationstypes File`
    - getters.js (depending wether you checked `Getters File`


## Icons
Icons provided by https://www.iconfinder.com/justicon via https://www.iconfinder.com
