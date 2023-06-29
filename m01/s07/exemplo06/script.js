// Selecionar o elemento
let titulo = document.querySelectorAll(".titulo")[1];
console.log(titulo);

// Adicionar uma classe
console.log(titulo.classList);
titulo.classList.add("destaque")
titulo.classList.add("etc")

if(titulo.classList.contains("etc")){
  titulo.classList.remove("titulo")
  console.log("Tem a classe etc");
} else {
  console.log("Não tem a classe etc");
  titulo.classList.add("etc");
  console.log("Agora tem =D");
}
