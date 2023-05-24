programa {
  funcao inicio() {
    // Declaração de variaveis
    inteiro: numeroDaSorte
    cadeia: mensagem

    // Entrada
    escreva("Escolha um número da sorte: \n ")
    leia(numeroDaSorte)

   // Processamento
   se (numeroDaSorte == 20)
      mensagem = "Parabéns você foi premiado!!"
   senao se (numeroDaSorte == 19)
      mensagem = "Você chegou perto!!"
   senao
      mensagem = "Não foi dessa vez =/ ... mas continue tentando"

    // Saida
    escreva(mensagem)
  }
}
