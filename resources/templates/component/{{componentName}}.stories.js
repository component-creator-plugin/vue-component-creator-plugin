import {{ componentNamePascalCase }} from './{{componentName}}.vue';

export default {
    title: '{{ componentNamePascalCase }}',
    component: {{ componentNamePascalCase }},
};

export const component = () => ({
    components: { {{ componentNamePascalCase }} },
    template: `<{{ componentName }} />`,
});
