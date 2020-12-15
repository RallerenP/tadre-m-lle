import { HyperHTMLElement } from "../HyperHTML/HyperHTMLElement.min.js";

export class CustomComponent extends HyperHTMLElement {
    constructor() {
        super();
        this._state = this.default();
    }

    _state = {}

    state() {
        return this._state
    }

    setState(obj) {
        this._state = {
            ...this._state,
            ...obj
        }
        this.render()
    }

    default() { };
}