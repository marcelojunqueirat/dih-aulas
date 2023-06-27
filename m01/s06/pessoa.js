class Pessoa {
  constructor(nome, idade, altura, peso, tamanhoPé, corOlho, corCabelo){
    this.nome = nome;
    this.idade = idade;
    this.altura = altura;
    this.peso = peso;
    this.tamanhoPé = tamanhoPé;
    this.corOlho = corOlho;
    this.corCabelo = corCabelo;
  }

  caminhar(){
    return 'Partiu caminhar.';
  }

  estudar(){
    return 'Bora focar nos estudos.';
  }

  dormir(){
    return 'ZZZ...'
  }

  comer(){
    return 'Partiu pizza!'
  }

  trabalhar(){
    return 'Worka porque money que é good nóis num have, se nóis hevasse nóis num tava aqui workando(just kidding)...'
  }

  fichaCadastral(){
    return `Meu nome é ${this.nome}, tenho ${this.idade} anos, minha altura é ${this.altura}m, peso ${this.peso}kg, tamanho do meu pé é ${this.tamanhoPé}, cor dos meus olhos é ${this.corOlho} e meu cabelo é da cor ${this.corCabelo}`
  }
}


let euMesmo = new Pessoa('Marcelo', 27, 1.92, 90, 44, 'castanho', 'preta')

console.log(euMesmo.fichaCadastral())
console.log(euMesmo.comer())
console.log(euMesmo.caminhar())
console.log(euMesmo.trabalhar())
console.log(euMesmo.estudar())
console.log(euMesmo.dormir())
