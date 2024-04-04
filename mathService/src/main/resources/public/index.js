function factor(){
    let inputValue = document.getElementById("value");
    let endPoint = "/factors?value=" + inputValue.value;
    let peticion = solicitarEndPoint(endPoint);
    peticion.then(respuesta => {
        let divResultFactor = document.getElementById("resultFactor");
        divResultFactor.innerHTML = respuesta;
    });
}

function primo(){
    let inputNumero = document.getElementById("numero");
    let endPoint = "/primes?value=" + inputNumero.value;
    let peticion = solicitarEndPoint(endPoint);
    peticion.then(resp => {
        let divResultPrimo = document.getElementById("resultPrimo");
        divResultPrimo.innerHTML = resp;
    });
}

async function solicitarEndPoint(endPoint){
    return await fetch(window.location.origin + endPoint)
    .then(result =>{
        if(!result.ok){
            throw new Error();
        }

        return result.text();
    })
    .catch(error => alert(error));
}