const urlArticulos = "http://localhost:3000/articulos"
let server = new XMLHttpRequest()
window.onload = () => {
    document.getElementById("verArticulos").addEventListener("click", () => {
        verArticulos()
    })
    document.getElementById("verProducto").addEventListener("click", () => {
        verProducto()
    })
    document.getElementById("nuevoProducto").addEventListener("click", () => {
        insert()
    })
    document.getElementById("actualizar").addEventListener("click", () => {
        updateProduc()
    })
    document.getElementById("borrar").addEventListener("click", () => {
        deleteProduct()
    })


    const ver = document.getElementById("ver")
}


function listArticuloCard(list) {
    ver.innerHTML = ""
    let result = `<ul>`
    list.forEach(a => {
        let card = `
        <li>
            ${a.id} - ${a.nombre} - ${a.precio}€
        </li>`
        result += card
    });
    result += "</ul>"
    ver.innerHTML = result
}

function verArticulos() {
    fetch(urlArticulos)
        .then(response => response.json())
        .then(data => listArticuloCard(data))
        .catch(e => alert("Network Error"));
}


function verProducto() {
    let id = prompt("Id del producto: ")
    fetch(urlArticulos)
        .then(response => response.json())
        .then(data => data.find(a => a.id == id))
        .then(producto => {
            ver.innerHTML = ""
            ver.innerHTML = `${producto.id} - ${producto.nombre} - ${producto.precio}€`
        })
        .catch(e => alert("Network Error"));
}

function findById(id) {
    return fetch(urlArticulos)
        .then(response => response.json())
        .then(data => {
            let result = data.find(a => a.id == id)
            return result != undefined
        })
        .catch(e => alert("Network Error"));
}


function insert() {
    let id = prompt("Id producto: ")
    
    findById(id).then(result => {
        if (result) {
            console.log("El producto con este ID ya existe.");
        } else {
            let name = prompt("Nombre del producto: ")
            let price = prompt("Precio producto: ")
            let producto = JSON.stringify({
                "id": id,
                "nombre": name,
                "precio": price
            })
            let option = {
                method: "POST",
                headers: {"Content-Type" : "application/json"},
                body: producto
            }

            fetch(urlArticulos,option)
            .then(response => {
                if (response.ok) {
                    return ver.innerHTML = `<h4 class="alert alert-success" role="alert">Ya se actualizo.</h4>`
                }
                alert("fallo al insertar")
            })
            .catch(e => alert("Network Error"))
        }
    })
}


function updateProduc() {
    let id = prompt("Id producto: ")
    
    findById(id).then(result => {
        if (result) {
            let name = prompt("Nombre del producto: ")
            let price = prompt("Precio producto: ")
            let product = JSON.stringify({
                "id": id,
                "nombre": name,
                "precio": price
            })
            let options = {
                method: "put",
                headers: {"Content-Type" : "application/json"},
                body: product
            }
            
            fetch(urlArticulos + "/" + id,options)
            .then(response => {
                console.log(response)
                if (response.ok) {
                    ver.innerHTML = `<h4 class="alert alert-success" role="alert">Ya se actualizo.</h4>`
                } else {
                    ver.innerHTML = `<h4 class="alert alert-danger" role="alert">Error al actualizar.</h4>`
                }
            })
            .catch(e => alert("Network Error"))
        } else {
            console.log("El producto con este ID no existe.");
        }
    })
}

function deleteProduct() {
    let id = prompt("Id producto: ")

    findById(id).then(result => {
        if (result) {
            fetch(urlArticulos + "/" + id,{method:"DELETE"})
            .then(response => {
                if (response.ok) {
                    ver.innerHTML = `<h4 class="alert alert-success" role="alert">Ya se a borrado.</h4>`
                } else {
                    ver.innerHTML = `<h4 class="alert alert-danger" role="alert">Error al borrar.</h4>`
                }
            })
            .catch(e => alert("Network Error"))
        } else {
            console.log("El producto con este ID no existe.");
        }

    })
}

