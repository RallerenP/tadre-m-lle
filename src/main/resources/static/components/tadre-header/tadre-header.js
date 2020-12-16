import { CustomComponent } from "../CustomComponent.js";



const {wire} = CustomComponent;

export class TadreHeader extends CustomComponent {
    constructor() {
        super();
    }

    render() {
        this.html`
        <script src="https://kit.fontawesome.com/7bc581f92a.js" crossorigin="anonymous"></script>
        <div class="bg-white w-100 h-20">
            <div class="w-1/2 h-20 mx-auto flex flex-row" id="template_append">
                <a class="text-2xl font-bold flex items-center" href="/">Tadre Mølles Venner</a>
                <div class="flex-grow"></div>
                <div class="flex items-center text-red-600">
                    ${this.state().content !== null ? this.state().content.map((el) => {
                        if (el.type === "link")
                            return wire(this, ':' + el.text)`<a class="px-4 hover:underline" href="${el.link}">${el.text}</a>`
                        else {
                            return wire(this, ':' + el.text)`
                                <a ref="dropdown-${el.text}" class="px-4 hover:underline" onclick="${() => {this.openDropdown(el)}}" href="#">${el.text} <i class="fas fa-caret-down"></i></a>
                                ${ el.isOpen ?
                                    wire(this, ':' + el.text + "-menu")`
                                    <div class="flex flex-col bg-default p-2" style="position: absolute; top: ${this.getElementPos(`dropdown-${el.text}`)[1]}px; left: ${this.getElementPos(`dropdown-${el.text}`)[0]}px;">
                                    ${el.children.map((child) => {
                                        
                                        return wire(this, ':' + child.text)`
                                            <a class="px-4 hover:underline" href="${child.link}">${child.text}</a>`
                                    })}
                                    </div>
                                    `
                                : 
                                null }
                            `    
                        }
                            
                    }): ''}
                    ${this.state().username !== "None" ?
                        wire(this)` 
                            <a class="px-4 hover:underline" href="/admin">Admin Dashboard</a>
                            <button class="px-4 hover:underline" onclick="${this.logout}">Log Ud</button>
                        `
                        :
                        null
                    }
                </div>
            </div>
        </div>
        `
    }

    created() {
        console.log("CREATED")
        this.getUser()
        this.getContent()
    }

    logout() {
        fetch("/api/auth/logout").then(() => window.location.reload())
    }

    openDropdown(el) {
        for (let element of this.state().content) {
            element.isOpen = el === element ? !element.isOpen : false;
        }
        this.render();
    }

    getElementPos(id) {
        return [this.refs[id].offsetLeft + 15,this.refs[id].offsetTop+this.refs[id].offsetHeight]
    }

    async getUser() {
        const response = await fetch("/api/auth/me")
        const text = await response.text()
        this.setState({
            username: text
        })
    }

    async getContent() {
        const response = await fetch("/api/config/navbar");
        let content;
        try {
            content = await response.json();
        } catch (e) {
            return [];
        }

        this.setState({content});
    }

    default() {
        return {
            username: "None",
            content: null
        }
    }
}

TadreHeader.define("tadre-header")
