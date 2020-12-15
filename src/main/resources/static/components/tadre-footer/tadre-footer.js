import {CustomComponent} from "../CustomComponent.js";

export class TadreFooter extends CustomComponent {
    constructor() {
        super();
    }

    created() {
        this.render();
    }

    render() {
        this.html`
            <div class="mt-16 w-screen h-16 px-16 flex justify-center items-center">
                © Tadre Mølles Venner ${this.state().year} 
            </div>
                   
        `
    }

    default() {
        return { year: new Date().getFullYear() }
    }
}

TadreFooter.define("tadre-footer")
