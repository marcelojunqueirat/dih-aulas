let contador = 10;

const contagemRegressiva = setInterval(() => {
  console.log(contador--)
  if(contador < 0){
    clearInterval(contagemRegressiva);
    console.log("Fim da contagem regressiva!")
  }
}, 1000)

