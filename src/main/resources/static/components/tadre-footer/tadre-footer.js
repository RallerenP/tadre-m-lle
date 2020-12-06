import { html, define, children } from 'https://unpkg.com/hybrids@^4/src';
import { TadreCopyright } from '../tadre-copyright/tadre-copyright.js'

export const TadreFooter = {
    copyright: children(TadreCopyright),
    src: "",
    render: ({src, copyright}) => html`
        <link href="/css/tailwind.min.css" rel="stylesheet">
        <link href="/css/custom.css" rel="stylesheet">
        <slot name="copyright" />
    `
}

define('tadre-footer', TadreFooter);