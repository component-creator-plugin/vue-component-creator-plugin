<template>
    <div class="{{ componentName }}">
        <pre v-text="$attrs"/>
    </div>
</template>

<script>
    export default {
        name: '{{componentNamePascalCase}}'
    };
</script>
