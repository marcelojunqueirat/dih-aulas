
let nomes = ['Marcelo', 'Maria', 'Matilda']

// LENGTH
console.log(nomes.length);

// PUSH (adiciona elemento no final da lista) e POP(remove ultimo elemento)
nomes.push("Scarlett", "Feiurinha")
nomes.pop()
console.log(nomes)

// UNSHIFT (adiciona elemento no inicio da lista) e SHIFT(remove primeiro elemento)
nomes.unshift("Jesuina", "Dimitria")
nomes.shift()
console.log(nomes)

// SPLICE altera um array, removendo, substituindo ou adicionando elementos especificos.
nomes.splice(3,1) // remove indice 3, apenas 1 elemento
nomes.splice(2,1, "Lindsay") // subtitui indice 2, apenas 1 elemento, novo valor "Lindsay"
console.log(nomes)

// SLICE retorna uma copia superficial de uma porção do array
let nomesSelecionados = nomes.slice(1,3) // posição 1 até posição 3, trara indice 1 e 2
console.log(nomesSelecionados) 
console.log(nomes)

// for of
for (let nome of nomes) {
  console.log(nome)
}