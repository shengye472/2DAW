criterios = ["Sin ordenar", "Ascendente por precio", "Descendente por precio"]

const carrito = new Carrito


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
	verCarro()
}


function verCarro() {
	const dialogo = document.getElementById("dialogContent")
	dialogo.innerHTML = ""
	let contenidoTabla = `
	<table class="table table-striped table-bordered">
		<theader>
			<tr class="table-light">
				<th>&nbsp</th>
				<th>nombre</th>
				<th>descripcion</th>
				<th>precio</th>
				<th>unidades</th>
				<th>total</th>
				<th>&nbsp</th>
			</tr>
		</theader>
		<tbody>
	`
	lista.forEach(a => {
		let tabla = `
			<tr>
				<td><img width = 60px src="assets/${a.codigo}.jpg" ></td>
				<td class="align-middle">${a.nombre}</td>
				<td class="align-middle">${a.descripcion}</td>
				<td class="align-middle">${a.precio}</td>
				<td class="align-middle">${a.unidades}</td>
				<td class="align-middle">${a.total}</td>
				<td class="align-middle">
					<button class="btn btn-primary" id="inc-${a.codigo}">+</button>
						<button class="btn btn-warning" id="dec-${a.codigo}">-</button>
						<button class="btn btn-danger" id="del-${a.codigo}">Borrar</button>
				</td>
		</tr>`
		contenidoTabla += tabla
	})

	contenidoTabla += `
	</tbody>
	</table>`

	dialogo.innerHTML = contenidoTabla
}

function efectuaPedido() {

}

window.onload = () => {
	pintaArticulos()
	ponIdBotonArticulo()
	verCarro()
	document.getElementById("miCarro").onclick = () => document.getElementById("miDialogo").showModal()
	document.getElementById("btnCierraDialog").onclick = () => document.getElementById("miDialogo").close()
}

