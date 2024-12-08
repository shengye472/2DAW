const url = "http://localhost:3000/articulos"
const ver = document.getElementById("divArticulos")
const dialogNuevo = document.getElementById("dialogNuevo")
const newProduct = document.getElementById("btnNuevo")
const formNuevo = document.getElementById("formNuevo")
const cancelarNuevo = document.getElementById("btnCancelarNuevo")
const dialogMod = document.getElementById("dialogModificar")
const formMod = document.getElementById("formModificar")
const cancelarMod = document.getElementById("btnCancelarModificar")

window.onload = () => {
    show()
    newProduct.addEventListener("click", () => {
        insert()
    })
}

function pintarArticulo(data) {
    ver.innerHTML = ""
    let result = `
            <table class="table table-striped">
                <th> ID </th>
                <th> Nombre </th>
                <th> Precio </th>
                <th> &nbsp </th>
        `
    data.forEach(a => {
        result += `
            <tr>
                <td>${a.id}</td>
                <td>${a.nombre}</td>
                <td>${a.precio}€</td>
                <td class="text-center">
                    <button id="${a.id}" class="btn btn-success">Modificar</button>
                    <button id="${a.id}" class="btn btn-danger">Borrar</button>
                </td>
            </tr>
        `
    });

    result += `</table>`
    ver.innerHTML = result

    Array.from(ver.getElementsByClassName("btn-success")).forEach(a => {
        a.addEventListener("click", () => getPById(a.id))
    })
    Array.from(ver.getElementsByClassName("btn-danger")).forEach(a => {
        a.addEventListener("click", () => deleteById(a.id))
    })
}

function show() {
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Mi Error ${response.status} ${response.statusText}`)
            }
            return response.json()
        })
        .then(data => {
            pintarArticulo(data)
        })
        .catch(error => alert("Network Error"))
}

function deleteById(id) {
    fetch(url + "/" + id, { method: "DELETE" })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Mi Error ${response.status} ${response.statusText}`)
            }
            show()
        })
        .catch(error => alert("Network Error"))
}

function insert() {
    dialogNuevo.showModal()
    formNuevo.reset()
    formNuevo.addEventListener("submit", (event) => {
        event.preventDefault()
        let id = formNuevo.id.value
        let name = formNuevo.nombre.value
        let price = formNuevo.precio.value
        let option = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ "id": id, "nombre": name, "precio": price })
        }
        fetch(url, option)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Mi Error ${response.status} ${response.statusText}`)
                }
                return response.json()
            })
            .then(data => {
                dialogNuevo.close()
                show()
            })
            .catch(error => alert("Network Error"))

    })
    cancelarNuevo.addEventListener("click", () => {
        dialogNuevo.close()
    })

}
function getPById(id) {
    fetch(url + "/" + id)
        .then(response => response.json())
        .then(data => setData(data))
        .catch(error => alert("Network Error"))

}

function setData(data) {
    dialogMod.showModal()
    formMod.id.value = data.id
    formMod.nombre.value = data.nombre
    formMod.precio.value = data.precio
    formMod.addEventListener("submit", (event) => {
        event.preventDefault()
        update()
    })
    cancelarMod.addEventListener("click", () => {
        dialogMod.close()
    })
}

function update() {
    const id = formMod.id.value
    const name = formMod.nombre.value
    const price = formMod.precio.value
    let option = {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ "id": id, "nombre": name, "precio": price })
    }

    fetch(url + "/" + id, option)
        .then((response) => {
            if (!response.ok)
                throw new Error(`${response.status}:${response.statusText}`)
            return response.json()
        })
        .then(data => {
            dialogMod.close()
            show()

        })
        .catch(error => {
            dialogMod.close()
            alert("Network Error")
        })

}