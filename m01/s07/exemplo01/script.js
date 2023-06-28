let pElement = document.getElementsByTagName('p')[0];
console.log(pElement);

//Obter o anterior/próximo nó irmão do elemento.
console.log(pElement.previousElementSibling);
console.log(pElement.nextElementSibling);

//Obter o nó pai do elemento.
console.log(pElement.parentNode);

//Obter os nós filhos do elemento.
console.log(pElement.childNodes); // traz tudo
console.log(pElement.children); //apenas elementos

/*-------------------------------------------- */

//Pegando elementos filhos por meio de um elemento pai
let form = document.querySelector('[name="formCadastro"]');
console.log(form);
console.log(form.nome);
console.log(form.sobrenome);
console.log(form.idade);
