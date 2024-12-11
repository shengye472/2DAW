// const matricula = new Matricula(1);

window.onload = () => {
    verAsignatura();
    // ponBotonAsignatura();
}

function verAsignatura() {
    let contenedor = document.getElementById("contenedor");
    contenedor.innerHTML = "";
    let result
    modulos.forEach(modulo => {
        result += pintarAsignatura(modulo);
    })
    contenedor.innerHTML = result;
}

function pintarAsignatura(modulo){
    let nombre = modulo.nombre.toLowerCase();
    let card = `
        <div class="card">
            <img src="assets/${nombre}.png" class="card-img-top">
            <button id="${modulo.codigo}" class="btn btn-primary"> ${modulo.nombre} </button>
        </div> 
    `
    return card;
}

function ponBotonAsignatura() {
    let botones = Array.from(document.getElementsByClassName("btn-primary"));
    botones.forEach(a => {
        a.addEventListener("click", () => {
            buscarAsignatura(a.id);
        })

    })
}

function buscarAsignatura(id) {
    let asignatuta = modulos.find(a => a.codigo == id);
    matricula.anyadeModulo(asignatuta);
}