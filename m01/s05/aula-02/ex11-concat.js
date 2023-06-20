let frutas = ["maçã", "banana"];
let frutas2 = ["laranja", "manga"];

console.log(frutas); // Imprime ['banana', 'laranja']
console.log(frutas2); // Imprime ['maçã', 'banana', 'laranja', 'manga']

let frutasPossiveis = frutas2.concat(frutas);

console.log(frutasPossiveis);
