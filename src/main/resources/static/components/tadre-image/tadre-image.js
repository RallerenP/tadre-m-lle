import { html, define } from 'https://unpkg.com/hybrids@4.3.3/src/index.js';

export const TadreImage = {
    src: "",
    render: ({src}) => html`
        <link href="/css/tailwind.min.css" rel="stylesheet">
        <link href="/css/custom.css" rel="stylesheet">
        <div class="image-container">
            <div class="mx-auto w-1/2">
                <img class="" src="${src}" alt="Billede af en vandmølle">
            </div>
        </div>
    `
}

define('tadre-image', TadreImage);