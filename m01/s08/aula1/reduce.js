let numeros = [12, 5, 2, 21, 8, 10]

let max = numeros.reduce((total, n ) => {
  // return total > n ? total : n;
  return Math.max(total, n);
});

console.log(max);