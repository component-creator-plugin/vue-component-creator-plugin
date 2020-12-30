import {{ componentNamePascalCase }} from './{{componentName}}.vue';
{{# createMarkdown = "1" }}
import markdown from './{{componentName}}.md';
{{/ createMarkdown = "1"}}

export default {
    title: '{{ componentNamePascalCase }}',
    component: {{ componentNamePascalCase }},
    {{# createMarkdown = "1" }}
    parameters: {
        notes: { markdown }
    },
    {{/ createMarkdown = "1" }}
};

export const Default = (args, {argTypes}) => ({
    props: Object.keys(argTypes),
    components: { {{ componentNamePascalCase }} },
    template: `<{{ componentName }} v-bind="$props" />`,
});
