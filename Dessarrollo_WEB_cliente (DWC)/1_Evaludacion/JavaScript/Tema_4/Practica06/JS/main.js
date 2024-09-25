// function suma (a){
//     console.log(typeof arguments)
//     console.log("numeros de argumentos " + arguments.length)
//     console.log(arguments)
//     console.log(a)
//     for (let index = 0; index < arguments.length; index++) {
//         console.log(arguments[index])
//     }

//     arguments.array.forEach(element => console.log(element))  
//     Array.from(arguments).forEach(element=>console.log(element))
// }

function suma (...datos){
    console.log(datos)
    datos.forEach(element => console.log(element));
}
suma(10,2,3,4,5,6)

let v1 = [1,2,3]
let v2 = [...v1]
console.log(v1)
console.log(v2)
v2[1] = "a" 
console.log(v1)
console.log(v2)

function hola() {
    console.log("Hola")
}

let hola2 = function () {
    console.log("Hola2")
}

let hola3 = () => console.log("Hola3")

hola()
hola2()
hola3()