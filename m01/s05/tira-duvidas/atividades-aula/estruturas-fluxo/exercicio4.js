// Escreva um programa que atribua um valor a uma  variável número e calcule a soma de todos os números de 1 até esse número. Use uma estrutura de repetição (for).

const numero = 5;

let soma = 0;

for (let i = 1; i <= numero; i++) {
    soma += i;
    console.log("-> ", soma);
}

console.log("A soma dos números de 1 até", numero, "é", soma);
