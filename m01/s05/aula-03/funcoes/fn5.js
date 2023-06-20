let num1 = 21;
let num2 = 33;

// function somar(a, b) {
//     return a + b;
// }

let resultado = somar(num1, num2);
console.log(typeof resultado);

var nums = [1, 2];
nums.pop();

function dizerOla() {
    console.log("Olá");
}

// function executaFuncao(fn) {
//     fn();
// }

// executaFuncao(dizerOla);

function somar(a, b) {
    console.log(a + b);
}

function executaFuncao(fn, a, b) {
    fn(a, b);
}

executaFuncao(somar, a, b);
