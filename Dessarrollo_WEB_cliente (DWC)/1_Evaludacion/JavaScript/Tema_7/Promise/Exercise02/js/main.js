const url = "http://localhost:3000/articulos"
const ver = document.getElementById("divArticulos")

window.onload = () => {

    show()
}

function pintarArticulo(data) {
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
                <td>${a.precio}</td>
                <td class="text-center">
                    <button id="${a.id}" class="btn btn-success">Modificar</button>
                    <button id="${a.id}" class="btn btn-danger">Borrar</button>
                </td>
            </tr>
        `
    });
    
    result += `</table>`
    ver.innerHTML = result

    Array.from(ver.getElementsByClassName("btn-danger")).forEach(a => {
        a.addEventListener("click", () => deleteById(a.id))
    }
    )
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
        .catch(error => alert(error))
}

function deleteById(id) {
    console.log(id)
}