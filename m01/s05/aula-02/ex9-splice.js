let frutas = ["laranja", "manga", "maçã", "banana"];

//Substitui dois elementos a partir da posição 1

frutas.splice(1, 0, "pequi");
// produtos.splice(
//     qualOIndice,
//     quantosElementosSeraSelecionado,
//     porQualElementoSeraSubstituido
// );

console.log(frutas); // Imprime ['laranja', 'uva', 'abacaxi', 'banana']

let frutas2 = ["laranja", "manga", "maçã", "banana"];
let posicaoManga = 2;
let diferencaDoTamanho = frutas2.length - posicaoManga;

frutas2.splice(posicaoManga, diferencaDoTamanho);
console.log(frutas2);
