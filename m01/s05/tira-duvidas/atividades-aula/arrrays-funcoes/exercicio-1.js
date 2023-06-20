/* Manipulação de array
    Crie um array vazio
    Adicione três cores (amarelo, vermelho e rosa)
    Adicione no começo da array (azul e roxo)
    Imprima o tamanho da array
    Crie uma outra array a partir da primeira array somente com as cores da posição 1 e 2 (roxo e amarelo)
    Agora volte na primeira array remova o último elemento (rosa)
    Agora junte as duas arrays e imprima os elementos
*/

// Criação de um array vazio
let cores = [];

// Adição de três cores ao array
cores.push("amarelo", "vermelho", "rosa");

// Adição de duas cores no começo do array
cores.unshift("azul", "roxo");

// Imprimir o tamanho da array
console.log("Tamanho da array: " + cores.length);

// Criação de outra array com as cores da posição 1 e 2 da primeira array
let segundaArray = cores.slice(1, 3);

// Remoção do último elemento da primeira array
cores.pop();

// Junção das duas arrays
let resultado = cores.concat(segundaArray);

// Impressão dos elementos da array resultante
console.log(resultado);
