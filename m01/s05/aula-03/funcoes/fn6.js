function somar(a, b) {
    console.log(a + b);
}

function executaFuncao(fn, a, b) {
    fn(a, b);
}

let a = 20;
let b = 30;
executaFuncao(somar, a, b);
// executaFuncao(somar(a, b));
