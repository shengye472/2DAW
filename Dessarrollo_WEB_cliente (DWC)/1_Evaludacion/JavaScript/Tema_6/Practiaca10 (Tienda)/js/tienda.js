criterios = ["Sin ordenar", "Ascendente por precio", "Descendente por precio"]

function creaListaCriterios() {
	
}


function pintaArticulos(orden) {
	const contenedor =  document.getElementById("contenedor");
	contenedor.innerHTML = ""
	listaArticulos.forEach(a => {
		let cards =`
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
					<button	button id="${a.codigo}" class="btn-success">comprar</button>
				</div>
			</div>`
		contenedor.innerHTML += cards;
	});
}

function ponArticuloEnCarrito() {
	const contenedor =  document.getElementById("contenedor");
	let botones = Array.from(contenedor.getElementsByClassName("success"));

	botones.forEach(a => {
		a.addEventListener("click",()=> console.log("${a.codigo}"))
	})
}


function verCarro() {
}

function efectuaPedido() {

}

window.onload = () => {
	pintaArticulos()
	ponArticuloEnCarrito()
}

