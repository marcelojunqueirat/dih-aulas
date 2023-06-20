let estados = [
    "Paraná",
    "Santa Catarina",
    "Rio Grande do Sul",
    "Rio de Janeiro",
];

// Adicionando os estados faltantes na ordem correta
estados.splice(3, 0, "São Paulo", "Minas Gerais");
console.log("Estados atualizados: ", estados.toString());

// Imprimindo os índices/posições dos estados 'São Paulo' e 'Minas Gerais'
console.log("Índice de São Paulo: " + estados.indexOf("São Paulo"));
console.log("Índice de Minas Gerais: " + estados.indexOf("Minas Gerais"));

// Verificando se existe o estado 'Mato Grosso do Sul' e imprimindo uma mensagem
if (estados.indexOf("Mato Grosso do Sul") === -1) {
    console.log("Logo estaremos atuando nesta região");
}
