# vue-component-creator
An Brainstorm Plugin to create single file vue.js components with a Sass file along them.
This plugins does a couple of things in order to simplify your dev experience.

## Create a Vue module
Right click in the project tree view where you want to place the new module. Then `New File` -> `Vue Module`.
This will open a dialog to define the module's name


## What it creates
After you create a new `Vue Module` with the action you'll have to name the module. This name is used later
to name the directory, vue- and sass-file as well as the sass root name, and a root node in the vue file
with the given name.

- my-module
  - my-module.vue
  - _my-module.scss


File: my-module.vue

    <template>
        <div class="my-module">
        </div>
    </template>

    <script>
        export default {
            props: {
            },
        };
    </script>


File: _my-module.scss

    .my-module {
        // Vars

        // Support

        // Module
        & {
        }

        // Facets

        // States

    }


