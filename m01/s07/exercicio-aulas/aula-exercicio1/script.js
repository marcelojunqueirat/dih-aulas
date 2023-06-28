/*
Busque os elementos da lista e imprima os elementos
Busque os elementos e apresente o valor do texto de cada elemento 
*/

let liElements = document.getElementsByTagName('li');
console.log(liElements);

// for (let li of liElements) {
//   console.log(li.innerText)
// }

Array.from(liElements).forEach((li) => {
  console.log(li.innerText);
})

/*
Busque e faça o log do elemento li do dipirona
Faça o log do valor texto 
 */

let liDipirona = document.querySelector('.mais-vendido');
console.log(liDipirona);
console.log(liDipirona.innerText);





