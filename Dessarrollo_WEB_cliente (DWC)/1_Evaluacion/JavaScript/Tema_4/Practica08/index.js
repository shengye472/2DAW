const persona = {
    nombre: "Juan",
    apellido: "Pérez",
    edad: 30,
    ciudad: "Valencia"
};

console.log(persona)

const persona2 = new Object;

persona2.nombre = "Pepe"
persona2.apellido = "Gomez"
persona2.edad = 20
persona2.ciudad = "Madrid"

console.log(persona2)

let edad = persona.edad

console.log(edad)

let propiedad = "nombre"

console.log(persona[propiedad])

console.log(persona.cp)

console.log("nombre" in persona)
console.log("cp" in persona)

persona.cp = undefined
console.log(persona.cp)

persona.cp = 46018
console.log(persona.cp)

for (const key in persona) {
    console.log(`${key}: ${persona[key]}`)
}


let propiedades = Object.keys(persona)

console.log(propiedades)

let persona3 = {
    apellido : "Gomez",
    nombre : "Pepe",
    ciudad : "Madrid",
    edad : 20 
}

console.log(persona2 == persona3)

console.log("=============================")

function comparationObject(o1, o2){
    let keys1 = Object.keys(o1)
    let keys2 = Object.keys(o2)

    for (const key in keys1) {
        for (const key2 in keys2){
            if(key.length == key2.length){
                if (key == key2){
                    if (o1[key] == o2[key2]){
                        return true
                    }else{
                        return false
                    }
                } else{
                    return false
                }
            }else{
                return false
            }
        }
    }
}

console.log(comparationObject(persona,persona3))