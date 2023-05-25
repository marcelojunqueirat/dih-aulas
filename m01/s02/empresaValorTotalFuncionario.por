programa {
  funcao inicio() {
    // Declaração de variaveis
    real valorTotal = 0.0, quantidadeHorasTrabalhadas = 0.0, valorHora = 0.0
    inteiro quantidadeFuncionarios = 0, contador = 1

    // Entrada
    escreva("Informe a quantidade de Funcionário(s): ")
    leia(quantidadeFuncionarios)

    para(contador; contador <= quantidadeFuncionarios; contador++){
      escreva("Funcionario " + contador + "\n")
      escreva("Informe a quantidade de horas trabalhadas: ")
      leia(quantidadeHorasTrabalhadas)
      escreva("Informe o valor da hora: ")
      leia(valorHora)

      // Processamento
      valorTotal = valorTotal + (quantidadeHorasTrabalhadas * valorHora)
    }
    
    // Saida
    escreva("O valor total que empresa terá que pagar para seus funcionarios é de R$:" + valorTotal)
  }
}
