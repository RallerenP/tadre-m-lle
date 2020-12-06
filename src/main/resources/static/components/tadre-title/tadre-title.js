import { html, define } from 'https://unpkg.com/hybrids@^4/src';

export const TadreTitle = {
    render: () => html`
    <link href="/css/tailwind.min.css" rel="stylesheet">
    <link href="/css/custom.css" rel="stylesheet">
    <div class="bg-white w-full text-center text-4xl flex justify-center items-center h-64">
        <slot />
    </div>
    `
}

define('tadre-title', TadreTitle);