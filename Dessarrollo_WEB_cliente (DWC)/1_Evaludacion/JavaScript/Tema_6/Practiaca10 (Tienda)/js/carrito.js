class Carrito {
	constructor(id) {
		
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
	}

	modificaUnidades(codigo, n) {
	}

	verCarrito() {
	}
}
