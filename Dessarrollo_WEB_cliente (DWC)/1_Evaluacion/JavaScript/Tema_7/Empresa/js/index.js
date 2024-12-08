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
    server.open("GET", urlArticulos)
    server.responseType = "json"
    server.send()
    server.onload = () => {
        let data = server.response
        listArticuloCard(data)
    }
    server.onerror = function () {
        alert("Network Error");
    };
}

function verProducto() {
    let id = prompt("Id del producto: ")
    server.open("GET", urlArticulos)
    server.responseType = "json"
    server.send()
    server.onload = () => {
        let data = server.response
        console.log(data)
        let producto = data.find(a => a.id == parseInt(id));
        ver.innerHTML = ""
        ver.innerHTML = `${producto.id} - ${producto.nombre} - ${producto.precio}€`
    }

    server.onerror = function () {
        alert("Network Error");
    };
}

// -- Necesario Promesas --
// function existId(id) {
//     server.open("GET", urlArticulos)
//     server.responseType = "json"
//     server.send()
//     server.onload = () => {
//         let data = server.response
//         data.forEach(a => {
//             if (id == a.id) {
//                 ver.innerHTML = `<h4 class="alert alert-danger" role="alert">Ya existe.</h4>`
//                 server.abort()
//             }
//         })
//     }
//     server.onerror = function () {
//         alert("Network Error");
//     };
// }

function insert() {
    let id = prompt("Id producto: ")
    let name = prompt("Nombre del producto: ")
    let price = prompt("Precio producto: ")

    let producto = JSON.stringify({
        "id": id,
        "nombre": name,
        "precio": price
    })
    server.open("post", urlArticulos)
    server.setRequestHeader('Content-type', 'application/json; charset=utf-8')
    server.send(producto)
    server.onload = () => {
        if (server.status == 201) {
            ver.innerHTML = `<h4 class="alert alert-success" role="alert">Ya se inserto.</h4>`
        } else {
            ver.innerHTML = `<h4 class="alert alert-danger" role="alert">Error al insertar.</h4>`
        }
    }
    server.onerror = function () {
        alert("Network Error");
    };
}


function updateProduc() {
    let id = prompt("Id producto: ")
    let name = prompt("Nombre del producto: ")
    let price = prompt("Precio producto: ")

    let producto = JSON.stringify({
        "id": id,
        "nombre": name,
        "precio": price
    })
    server.open("put", urlArticulos + "/" + id)
    server.setRequestHeader('Content-type', 'application/json; charset=utf-8')
    server.send(producto)
    server.onload = () => {
        if (server.status == 201) {
            ver.innerHTML = `<h4 class="alert alert-success" role="alert">Ya se actualizo.</h4>`
        } else {
            ver.innerHTML = `<h4 class="alert alert-danger" role="alert">Error al actualizar.</h4>`
        }
    }
    server.onerror = function () {
        alert("Network Error");
    };
}

function deleteProduct() {
    let id = prompt("Id producto: ")
    server.open("delete", urlArticulos + "/" + id)
    server.responseType = "json"
    server.send()
    server.onload = () => {
        if (server.status == 200) {
            ver.innerHTML = `<h4 class="alert alert-success" role="alert">Ya se borro.</h4>`
        } else {
            ver.innerHTML = `<h4 class="alert alert-danger" role="alert">Error al borrar.</h4>`
        }
    }
    server.onerror = function () {
        alert("Network Error");
    };
}

