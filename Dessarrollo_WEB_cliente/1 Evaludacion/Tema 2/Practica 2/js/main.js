import {articulos} from "./datos.js"
import {verMensaje} from "./utilidades.js"

window.onload=function(){
verMensaje()
alert("Total articulos: " + articulos.length)
}

let mybutton = document.getElementById("buttom")
mybutton.addEventListener('click',verMensaje)