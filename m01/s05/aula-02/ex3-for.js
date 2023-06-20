let nomes = ["Paty", "Antonio", "Lucas", "Kelvis"];

// buscar a informa de alunos do senai
for (var i = 0; i < nomes.length; i++) {
    var eProfessor = nomes[i] === "Kelvis";
    if (eProfessor) {
        console.log("Professor:", nomes[i]);
    } else {
        console.log("Aluno:", nomes[i]);
    }
}

console.log("Hello");
