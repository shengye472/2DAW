class Carrito {
	constructor(id) {
		this.id = id;
	}

	anyadeArticulo(articulo) {
		if (lista.find(a => a.codigo === articulo.codigo)) {
			articulo.unidades++
			articulo.total = articulo.precio * articulo.unidades
		}else{
			articulo.unidades = 1
			articulo.total = articulo.precio
			lista.push(articulo)
		}
	}

	borraArticulo(codigo) {
		lista.splice(lista.findIndex(a => a.codigo === codigo),1)
		if (lista.length === 0) {
			document.getElementById("miDialogo").close()
		}
	}

	modificaUnidades(codigo, n) {
		let producto = lista.find(a => a.codigo === codigo)
		producto.unidades += n
		if (producto.unidades === 0) {
			this.borraArticulo(codigo)
		}
		producto.total = producto.precio * producto.unidades
	}

	verCarrito() {
		document.getElementById("miDialogo").showModal()
		const dialogo = document.getElementById("dialogContent")
		dialogo.innerHTML = ""
		let total = 0
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
					<button class="btn btn-primary" id="${a.codigo}">+</button>
						<button class="btn btn-warning" id="${a.codigo}">-</button>
						<button class="btn btn-danger" id="${a.codigo}">Borrar</button>
				</td>
			</tr>`
			total += a.total
			contenidoTabla += tabla
		})



		contenidoTabla += `
				</tbody>
			</table>`

		dialogo.innerHTML = contenidoTabla

		document.getElementById("total").innerHTML = total
		
		Array.from(dialogo.getElementsByClassName("btn-danger")).forEach(a => {
			a.addEventListener("click",() => {
				this.borraArticulo(a.id)
				verCarro()
			})})
		Array.from(dialogo.getElementsByClassName("btn-primary")).forEach(a => {
			a.addEventListener("click",() => {
				this.modificaUnidades(a.id,1)
				verCarro()
			})})
		Array.from(dialogo.getElementsByClassName("btn-warning")).forEach(a => {
			a.addEventListener("click",() => {
				this.modificaUnidades(a.id,-1)
				verCarro()
			})})
	}
}
