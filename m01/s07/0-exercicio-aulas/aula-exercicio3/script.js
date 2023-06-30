let textos = ['texto 1', 'texto 2', 'texto 3'];
let pagina = document.getElementsByTagName('body')[0];

textos.forEach((texto) =>  {
  let element = document.createElement('h1');
  element.innerText = texto;
  pagina.appendChild(element)
})

let h1s = document.querySelectorAll('h1');
console.log(h1s);

h1s.forEach(element => {
  element.setAttribute("class", "blueBorder")
});

