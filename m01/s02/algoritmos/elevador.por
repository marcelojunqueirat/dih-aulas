programa {
  funcao inicio() {
    // Declaração de variaveis
    real: pesoPessoa1, pesoPessoa2, pesoPessoa3, pesoPessoa4, pesoMaximoPermitido, pesoTotal
    cadeia: mensagem

    // Entrada
    escreva("Informe o peso(KG) da primeira pessoa: \n ")
    leia(pesoPessoa1)
    escreva("Informe o peso(KG) da segunda pessoa: \n ")
    leia(pesoPessoa2)
    escreva("Informe o peso(KG) da terceira pessoa: \n ")
    leia(pesoPessoa3)
    escreva("Informe o peso(KG) da quarta pessoa: \n ")
    leia(pesoPessoa4)

    escreva("\n")
    escreva("Qual o peso(KG) máximo suportado pelo elevador?: \n ")
    leia(pesoMaximoPermitido)

   // Processamento
   pesoTotal = pesoPessoa1 + pesoPessoa2 + pesoPessoa3 + pesoPessoa4

   se (pesoTotal <= pesoMaximoPermitido )
      mensagem = "Bora!!"
   senao se (pesoTotal > pesoMaximoPermitido)
      mensagem = "Não é possível transportar peso que ultrapasse: " + pesoMaximoPermitido + " KGs"
   senao
      mensagem = "Valor digitado invalido!"

    // Saida
    escreva(mensagem)
  }
}
