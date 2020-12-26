import {{ componentNamePascalCase }} from './{{componentName}}.vue';
{{# createMarkdown }}
import markdown from './{{componentName}}.md';
{{/ createMarkdown }}

export default {
    title: '{{ componentNamePascalCase }}',
    component: {{ componentNamePascalCase }},
    argTypes: {},
    {{# createMarkdown }}
    parameters: {
        notes: { markdown }
    },
    {{/ createMarkdown }}
};

export const component = (args, {argTypes}) => ({
    props: Object.keys(argTypes),
    components: { {{ componentNamePascalCase }} },
    template: `<{{ componentName }} v-bind="$props" />`,
});
