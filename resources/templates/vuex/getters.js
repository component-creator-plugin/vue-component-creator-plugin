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
