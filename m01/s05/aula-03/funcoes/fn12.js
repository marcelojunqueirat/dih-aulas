// let somarNumero = function () {
//     console.log("Outro 1: ", outroNum);
// };

// mostrarNumero();

let dizerOla = function () {
    console.log("Olá Mundo!");
};

// Arrow Functions
let dizerOlaArrow = () => {
    console.log("Olá Mundo!");
};

let dizerOlaArrow2 = () => console.log("Olá Mundo!");

let dizerOlaArrow3 = (nome) => console.log(`Olá ${nome}!`);

dizerOla();
dizerOlaArrow();
dizerOlaArrow2();
dizerOlaArrow3("Kelvis");

let nums = [1, 2, 3, 4, 5];

nums.forEach((item) => console.log(item));

nums.forEach(function (item) {
    console.log(item);
});
