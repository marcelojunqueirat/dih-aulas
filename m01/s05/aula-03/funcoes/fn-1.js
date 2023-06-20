let pessoas = ["kelvis", "joaquim"];

function adicionaPessoa() {
    pessoas.push("Matheus");
}

function removePessoaDoInicio(fim, outroValor) {
    if (fim) {
        pessoas.pop();
    } else {
        pessoas.shift();
    }
}

removePessoaDoInicio(true, 2);
console.log(pessoas);
