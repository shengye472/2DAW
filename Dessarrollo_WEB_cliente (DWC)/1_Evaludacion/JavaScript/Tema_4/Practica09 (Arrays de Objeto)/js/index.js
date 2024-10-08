"use strict"
let alumnos = [{
    'codigo': 'DAW-1-2020',
    'nombre': 'Pepe',
    'ciudad': 'Valencia',
    'calificaciones': [{ 'asignatura': 'PRG', 'nota': 9 },
    { 'asignatura': 'GBD', 'nota': 6 },
    { 'asignatura': 'ING', 'nota': 4 },
    { 'asignatura': 'FOL', 'nota': 3 }
    ],
    'edad': 24
},
{
    'codigo': 'DAW-2-2020',
    'nombre': 'Juan',
    'ciudad': 'Castellon',
    'calificaciones': [{ 'asignatura': 'DWC', 'nota': 4 },
    { 'asignatura': 'DWS', 'nota': 6 },
    { 'asignatura': 'DAW', 'nota': 7 },
    { 'asignatura': 'DIW', 'nota': 8 },
    { 'asignatura': 'ING', 'nota': 9 },
    { 'asignatura': 'EIE', 'nota': 2 }
    ],
    'edad': 28
},
{
    'codigo': 'DAW-1-2019',
    'nombre': 'Ana',
    'ciudad': 'Valencia',
    'calificaciones': [{ 'asignatura': 'PRG', 'nota': 6 },
    { 'asignatura': 'GBD', 'nota': 2 },
    { 'asignatura': 'ING', 'nota': 6 },
    { 'asignatura': 'FOL', 'nota': 2 }
    ],
    'edad': 22
},
{
    'codigo': 'DAW-2-2020',
    'nombre': 'Maria',
    'ciudad': 'Castellon',
    'calificaciones': [{ 'asignatura': 'DWC', 'nota': 4 },
    { 'asignatura': 'DWS', 'nota': 6 },
    { 'asignatura': 'DAW', 'nota': 7 },
    { 'asignatura': 'DIW', 'nota': 8 },
    { 'asignatura': 'ING', 'nota': 4 },
    { 'asignatura': 'EIE', 'nota': 1 }
    ],
    'edad': 30
}
]


function notasAlumno() {
    let alumno = prompt("Nombre alumno: ")
    let notaMedia = 0
    let notaMin = 0
    let notaMax = 0
    let resultado = alumnos.filter(n => alumno === n.nombre)

    

    console.log("Nota media es: " + notaMedia )
    console.log("Nota minima es: " + notaMedia)
    console.log("Nota maxima es: " + notaMedia)
}

function subeUnPunto() {
    alumnos.forEach(a => a.calificaciones.forEach(n => n.nota == 10 ? "Nota mas alta": n.nota++))
    console.log(alumnos)
}

function alumnosCiudad(){
    let ciudad = prompt("Nombre ciudad: ")

    let aluciudad = alumnos.filter(n => n.ciudad === ciudad)

    console.log(aluciudad)

}

function alumnosCurso(){
    let curso = prompt("Curso: ")

    let alucurso = alumnos.filter(n => n.codigo.split("-")[1] === curso)

    console.log(alucurso)
}

function ordenaEdad() {
    alumnos.sort((a,b) => a.edad - b.edad)
    console.log(alumnos)
}