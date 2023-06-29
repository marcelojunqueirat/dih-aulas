// Adicionando atributo src e alt a tag <img>
let imagem = document.getElementById("myImage");
// imagem.setAttribute("src", "https://ps.w.org/tiny-compress-images/assets/icon-256x256.png");
// imagem.setAttribute("alt", "Foto de um panda lunatico");
// imagem.setAttribute("width", "20");
// imagem.setAttribute("height", "20");

console.log(imagem.getAttributeNames());

let objImagem = {
  src: "https://ps.w.org/tiny-compress-images/assets/icon-256x256.png",
  alt: "Foto de um panda lunatico",
  width: "200",
  height: "200",
}

for (const key in objImagem) {
  const element = objImagem[key];
  imagem.setAttribute(key, element)
}

