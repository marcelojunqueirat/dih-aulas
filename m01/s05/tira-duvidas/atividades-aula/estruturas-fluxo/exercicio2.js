// Escreva um programa que atribua um valor a
// uma  variável número de 1 a 7 e imprima o
// dia da semana correspondente. Utilize uma
// estrutura condicional (switch) para
// fazer o mapeamento dos números para os dias da semana.

const numero = 3;

switch (numero) {
    case 1:
        console.log("Domingo");
        break;
    case 2:
        console.log("Segunda-feira");
        break;
    case 3:
        console.log("Terça-feira");
        break;
    case 4:
        console.log("Quarta-feira");
        break;
    case 5:
        console.log("Quinta-feira");
        break;
    case 6:
        console.log("Sexta-feira");
        break;
    case 7:
        console.log("Sábado");
        break;
    default:
        console.log("Número inválido");
        break;
}
