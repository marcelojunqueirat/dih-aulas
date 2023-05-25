programa {
  funcao inicio() {
    // Declaração de variaveis
    real: salarioMensal, quantidadeHorasTrabalhadas, resultado
    cadeia: mensagem

    // Entrada
    escreva("Por gentileza, informe o salário mensal(R$): \n ")
    leia(salarioMensal)
    
    escreva("\n")
    escreva("Informe a quantidade de horas trabalhadas no mês: \n ")
    leia(quantidadeHorasTrabalhadas)

   // Processamento
   resultado = salarioMensal / quantidadeHorasTrabalhadas

   se (resultado > 0)
      mensagem = "O valor hora do colaborador é R$ " + resultado
   senao
      mensagem = "Falha na operação, contate o suporte tecnico"

    // Saida
    escreva(mensagem)
  }
}
