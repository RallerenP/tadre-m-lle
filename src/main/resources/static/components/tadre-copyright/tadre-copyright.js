import { html, define } from 'https://unpkg.com/hybrids@^4/src';

export const TadreCopyright = {
    src: "",
    render: ({}) => html`
        <link href="/css/tailwind.min.css" rel="stylesheet">
        <link href="/css/custom.css" rel="stylesheet">
        <p>Ⓒ ${new Date().getFullYear()} Tadre Mølles Venner</p>
    `
}

define('tadre-copyright', TadreCopyright);