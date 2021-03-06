import {html, define} from 'https://unpkg.com/hybrids@4.3.3/src/index.js';

export const TadreContent = {
    render: () => html`
    <link href="/css/tailwind.min.css" rel="stylesheet">
    <link href="/css/custom.css" rel="stylesheet">
    
    <div class="mx-auto w-1/2 text-center text-2xl">
        <slot />
    </div>
    `
}

define('tadre-content', TadreContent);