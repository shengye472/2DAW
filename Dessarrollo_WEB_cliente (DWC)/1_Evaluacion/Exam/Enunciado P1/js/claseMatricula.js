// Definicion clase Matricula		
class Matricula {
	constructor() {
		this.id = id;
		this.lista = [];
	}

	anyadeModulo(codigo) {
		if (this.lista.includes(codigo)) {
			alert("Ya has matriculado este módulo");
		}else{
			this.lista.push(codigo);
		}
	}

	borraModulo(codigo) {
	}

	verMatricula() {
		let matriculas = document.getElementById("capaMatricula");
		matriculas.innerHTML = "";
		let result = `
			<table class="table table-striped table-bordered">
				<theader>
					<tr class="table-light">
						
					</tr>
				</theader>
		`;
	}

}