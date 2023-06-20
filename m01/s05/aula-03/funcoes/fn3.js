// function somarTresNumeros(a, b, c = 20) {
//     console.log("a: ", a);
//     console.log("b: ", b);
//     console.log("c: ", c);
//     console.log("Soma: ", a + b + c);
// }

// somarTresNumeros(2, 3, 50);

// somarTresNumeros(123, 312, 6577);

function bemVindo(nome = "meu amigo") {
    console.log(`Bem vindo, ${nome} !`);
}

// bemVindo();
// bemVindo("Paty");
// bemVindo("Lucas");
// bemVindo("Leonardo");
// bemVindo("Matheus");

let nomes = ["Paty", "Lucas", "Leonardo", "Matheus"];

for (const nome of nomes) {
    bemVindo(nome);
}
