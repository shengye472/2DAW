criterios = ["Sin ordenar", "Ascendente por precio", "Descendente por precio"]

const carrito = new Carrito(1)


function creaListaCriterios() {

}


function pintaArticulos(orden) {
	const contenedor = document.getElementById("contenedor");
	contenedor.innerHTML = ""
	listaArticulos.forEach(a => {
		let cards = `
			<div class="col">
				<div class="card">
					<img src="assets/${a.codigo}.jpg" class-"card-img-top">
					<div class="card-body">
						<h5 class="card-title">${a.nombre}</h5>
						<p class="card-text">${a.descripcion}</p>
						<b>
							<p class="card-text text-center">${a.precio}</p>
						</b>
					</div>
					<button	button id="${a.codigo}" class="btn-success boton-id">comprar</button>
				</div>
			</div>`
		contenedor.innerHTML += cards;
	});
}

function ponIdBotonArticulo() {
	let botones = Array.from(contenedor.getElementsByClassName("boton-id"));
	botones.forEach(a => {
		// a.addEventListener("click",function(){console.log(this.id)})
		a.addEventListener("click", () => buscarArticulo(a.id))
	})
}

function buscarArticulo(id) {
	let articulo = listaArticulos.find(a => a.codigo === id)
	ponArticuloEnCarrito(articulo)
}

const lista = []

function ponArticuloEnCarrito(articulo) {
	carrito.anyadeArticulo(articulo)
	console.log(lista)
}


function verCarro() {
	if (lista.length === 0) {
		alert("El Carro esta vacio")
	} else {
		carrito.verCarrito()
	}
}

function efectuaPedido() {

}

window.onload = () => {
	pintaArticulos()
	ponIdBotonArticulo()
	document.getElementById("miCarro").onclick = () => verCarro()
	document.getElementById("btnCierraDialog").onclick = () => document.getElementById("miDialogo").close()
}

