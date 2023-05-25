programa {
  funcao inicio() {
    // Declaração de variaveis
    real depositoAux = 0, resultado = 0, saqueAux = 0
    cadeia mensagem
    caracter opcao

    faca {
      // Menu
      // Entrada
      escreva("\n\nSELECIONE UMA OPÇÃO \n")
      escreva("1) consultar saldo \n")
      escreva("2) realizar um depósito \n")
      escreva("3) realizar um saque \n")
      escreva("4) Sair \n")
      leia(opcao)
      escreva("\n")

      escolha opcao {
        // Processamento
        caso "1"
          mensagem = "O saldo atual é de: R$" + resultado
          pare
        caso "2"
          escreva("Qual o valor(R$) que deseja DEPOSITAR? \n")
          leia(depositoAux)
          resultado = resultado + depositoAux
          mensagem = "Valor depositado com sucesso! O saldo atual é de: R$" + resultado
          pare
        caso "3"
          escreva("Qual o valor(R$) que deseja SACAR? \n")
          leia(saqueAux)

          se (saqueAux > resultado) {
            mensagem = "Saldo insuficiente.\n" 
          } senao {
            resultado = resultado - saqueAux
            mensagem = "Saque realizado com sucesso! O saldo atual é de: R$" + resultado
          }
          pare
        caso "4"
          mensagem = "Adeus."
          pare
        caso contrario
          mensagem = "Opção Inválida!"
          pare
      }

      // Saida
      escreva(mensagem)

    } enquanto(opcao != 4)
  }
}
