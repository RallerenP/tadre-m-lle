import {HyperHTMLElement} from "../../HyperHTML/HyperHTMLElement.min.js";

export class TadreHeader extends HyperHTMLElement {
    _state = {
        username: "Noget andet"
    }
    render() {
        this.html`
        <link href="/css/tailwind.min.css" rel="stylesheet">
         <link href="/css/custom.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
         <div class="bg-white w-100 h-20">
             <div class="w-1/2 h-20 mx-auto flex flex-row" id="template_append">
                 <h1 class="text-2xl font-bold flex items-center">Tadre Mølles Venner</h1>
                 <div class="flex-grow"></div>
                 <div class="flex items-center text-red-600">
                    <a class="px-4 hover:underline" href="/">gaming</a>
                    ${this.state().username !== "None" ?
                        HyperHTMLElement.wire`
                        <a class="px-4 hover:underline" href="/">Admin Dashboard</a>
                        <button class="px-4 hover:underline" onclick="${this.logout}">Log Ud</button>`
                        :
                        HyperHTMLElement.wire``
                    }
                    
                 </div>
             </div>
         </div>
        `
    }

    created() {
        console.log("CREATED")
        getUser((text) => {
            this.setState({
                username: text
            })
        })
    }

    state() {
        return this._state
    }

    setState(obj) {
        this._state = {
            ...this._state,
            ...obj
        }
        this.render()
        console.log(this.state())
    }

    logout() {
        fetch("/api/auth/logout").then(() => window.location.reload())
    }

}


export async function getUser(fn) {
    const response = await fetch("/api/auth/me")
    const text = await response.text()
    console.log(text)
    fn(text)
}

/*function renderButton() {
    return html.resolve(getUser().then((username) =>{
        if (username === "None") { return html`
        <a class="px-4 hover:underline" href="login.html">Log Ind</a>
        `}
        else { return html`
        <a class="px-4 hover:underline" href="/admin">Admin Dashboard</a>

        ` }
    }), html`PLACEHOLDER`, 5000)
}*/

function getJSON() {
    return [
            {
                text: "dropdown-menu",
                type: "dropdown",
                isOpen: false,
                children: [
                    {
                        text: "Link",
                        type: "link",
                        link: "/link"
                    },
                    {
                        text: "Link2",
                        type: "link",
                        link: "/link2"
                    }
                ]
            },
            {
                text: "Link3",
                type: "link",
                link: "/link3"
            }
        ]
}

TadreHeader.define("tadre-header")
