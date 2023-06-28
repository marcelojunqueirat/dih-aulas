/* <ul>
  <li>Aluno 1</li>
  <li>Aluno 2</li>
  <li>Aluno 3</li>
</ul> */

//Acrescentando elementos via js no html
let nomes = ['Aluno 1', 'Aluno 2', 'Aluno 3']
let body = document.getElementsByTagName('body')[0];
let ulElement = document.createElement('ul');

let criarElemento = (lista) => {
  lista.forEach((nome) => {
    let liElement = document.createElement('li');
    liElement.innerText = nome;
    ulElement.appendChild(liElement);
  })
}

body.appendChild(ulElement);
criarElemento(nomes);

let estilos = `
  background:green;
  color:blue
`;
// Adiciona um novo elemento <li> usando innerHTML
ulElement.innerHTML += `<li style="${estilos}">Novo parágrafo adicionado</li>`;

// Filhos para saber qual irmao sera o "novo proximo"
let itensLi = document.getElementsByTagName('li');
console.log(itensLi);
//Novo elemento
let liElementBefore = document.createElement('li');
liElementBefore.innerText = 'Entre Aluno 2 e Aluno 3';
ulElement.insertBefore(liElementBefore, itensLi[2])

let ultimo = document.createElement('li');
ultimo.innerText='Ultimo';
ulElement.insertBefore(ultimo, null) //caso queira inserir no final macete é usar NULL

