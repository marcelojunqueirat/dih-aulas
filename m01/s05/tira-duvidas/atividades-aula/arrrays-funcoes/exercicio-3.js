// Lista de estados da Clamed Farmácias
let estados = [
    "Paraná",
    "Santa Catarina",
    "Rio Grande do Sul",
    "São Paulo",
    "Minas Gerais",
    "Rio de Janeiro",
];

// Função para adicionar um estado na lista
function adicionarEstado(nomeEstado) {
    // Verifica se o estado já existe na lista
    if (estados.includes(nomeEstado)) {
        console.log(`Estado (${nomeEstado}) já está na lista`);
    } else {
        // Adiciona o estado na lista
        estados.push(nomeEstado);
        console.log(
            `Estado (${nomeEstado}) acabou de ser adicionado, pois ainda não estava cadastrado`
        );
    }
}

// Chamando a função para adicionar os estados
adicionarEstado("Mato Grosso");
adicionarEstado("Santa Catarina");

console.log("Lista de estado atualizada:", estados.toString());
