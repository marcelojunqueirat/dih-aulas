// Adicionando atributo src e alt a tag <img>
let imagem = document.getElementById("myImage");
imagem.setAttribute("src", "https://ps.w.org/tiny-compress-images/assets/icon-256x256.png");
imagem.setAttribute("alt", "Foto de um panda lunatico");
imagem.setAttribute("width", "20");
imagem.setAttribute("height", "20");

// Busca o valor do atributo alt
console.log(imagem.getAttribute("alt"));

// remove a propriedade height
imagem.removeAttribute("height");
let buttonSave = document.querySelector('button');
buttonSave.removeAttribute('disabled');
/* 3 segundos para habilitar
setTimeout(() => {
  buttonSave.removeAttribute("disabled");
}, 3000)*/





