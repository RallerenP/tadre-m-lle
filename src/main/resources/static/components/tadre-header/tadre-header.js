import { html, define } from 'https://unpkg.com/hybrids@4.3.3/src/index.js';

export const TadreHeader = {
    render: () => html`
        <link href="/css/tailwind.min.css" rel="stylesheet">
        <link href="/css/custom.css" rel="stylesheet">
        <div class="bg-white w-100 h-20">
            <div class="w-1/2 h-20 mx-auto flex flex-row">
                <h1 class="text-2xl font-bold flex items-center">Tadre Mølles Venner</h1>
                <div class="flex-grow"></div>
                <div class="flex items-center text-red-600">
                    <a class="px-4 hover:underline" href="/">Home</a>
                    <a class="px-4 hover:underline" href="/galleri.html">Second Item</a>
                    <a class="px-4 hover:underline" href="/third-item">Third Item</a>
                    <a class="px-4 hover:underline" href="/fourth-item">Fourth Item</a>
                </div>
            </div>
        </div>
    `
}

define('tadre-header', TadreHeader);