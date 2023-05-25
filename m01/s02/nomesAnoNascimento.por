programa {
  funcao inicio() {
    // Declaração de variaveis
    cadeia nomes[3]
    inteiro anoAtual = 2023, anoNascimento = 0, anos[3]

    // Entrada
    para(inteiro i = 0; i <= 2; i++){
      escreva("Informe seu nome: ")
      leia(nomes[i])

      escreva("Informe ano de nascimento: ")
      leia(anoNascimento)
      anos[i] = anoAtual - anoNascimento
      escreva("\n")
    }

    // Saida
    para(inteiro i = 0; i <= 2; i++){
      escreva("Nome: " + nomes[i] + ", Idade: " + anos[i] + " \n")
    }

  }
}
