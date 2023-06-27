let linguagens = ['cobol', 'php', 'c#'];

//ADICIONAR NO FINAL
linguagens.push('java');

//ADICIONAR NO INICIO
linguagens.unshift('python');

//ADICIONAR NO MEIO
// splice(posição, quantos elementos serao removidos, elemento a ser adicionado)
linguagens.splice(3, 0, 'Ruby')

// REMOVER NO FINAL
linguagens.pop();

// PERCORRER O ARRAY
linguagens.forEach((linguagem) => {
  console.log(`A linguem é ${linguagem}`)
})

// TRANSCREVER UM ARRAY
let numeros = [2, 4, 6, 8];
let dobro = numeros.map((numero) => {
  return numero*2;
})
console.log(dobro)

// FILTRAR ARRAY
numerosFiltrados = numeros.filter((numero) => {
  return numero > 5;
})
console.log(numerosFiltrados)



