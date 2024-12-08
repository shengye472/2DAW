const formulario = document.getElementById("formulario")
const inputName = document.getElementById("name")
const errorName = document.getElementById("errorName")
const inputEmail = document.getElementById("email")
const errorEmail = document.getElementById("errorEmail")


formulario.addEventListener('submit', function(event){
    event.preventDefault();

    errorName.innerHTML = ""
    errorEmail.innerHTML = ""

    let value = true;

    let name = inputName.value.trim()
    let email = inputEmail.value.trim()

    if (name === "") {
        value = false
        errorName.innerHTML = "no puede estar vacio"
    } else if (name.length < 5) {
        value = false
        errorName.innerHTML = "tiene que ser mas de 5 letras"
    }

    if (email === "") {
        value = false
        errorEmail.innerHTML = "email no puede estar vacio"
    } else if (!validarEmail(email)) {
        errorEmail.innerHTML = "error"
    }

    if (value) {
        alert("enviado")
    }
    console.log("hola")
})

function validarEmail(email) {
    const regex =
    /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[azA-Z]{2,}))$/;
    return regex.test(email);
    }
    