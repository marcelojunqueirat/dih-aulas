/*Agora você precisa adicionar na sua lista alguns produtos baby

BEPANTOL BABY 100G + 20G CREME
TOALHA UMEDECIDA NATURAL BABY LEVE 100 PAGUE 80 ESPECIAL
FRALDA HUGGIES TRIPLA PROTECAO COM 78 LEVE + PAGUE - TAMANHO G HIPER ESPECIAL
 */

let nomes = ['BEPANTOL BABY 100G + 20G CREME', 'TOALHA UMEDECIDA NATURAL BABY LEVE 100 PAGUE 80 ESPECIAL', 'FRALDA HUGGIES TRIPLA PROTECAO COM 78 LEVE + PAGUE - TAMANHO G HIPER ESPECIAL']

let ulElement = document.getElementsByTagName('ul')[0];

let criarElementoLista = (lista) => {
  lista.forEach((nome) => {
    let liElement = document.createElement('li');
    liElement.innerText = nome;
    ulElement.appendChild(liElement);
  })
}

let criarElemento = ((texto) => {
  let liElement = document.createElement('li');
  liElement.innerText = texto;
  ulElement.appendChild(liElement);
})

criarElementoLista(nomes)
criarElemento('teste')

let liDipirona = document.querySelector('.mais-vendido');
liDipirona.remove();
