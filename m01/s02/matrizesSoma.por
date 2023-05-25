programa {
  funcao inicio() {
    real mat[3][3] = 
    {
      { 10, 20, 30}, 
      { 40, 50, 60}, 
      { 70, 80, 90}
    }
    real somaPrimeiraLinha = 0.0, somaSegundaColuna = 0.0

    para (inteiro i = 0; i < 3; i++) {
      para (inteiro j = 0; j < 3; j++) {
        se (mat[i][j] == mat[0][j]) {
          somaPrimeiraLinha = somaPrimeiraLinha + mat[i][j]
        }

        se (mat[i][j] == mat[i][1]) {
          somaSegundaColuna = somaSegundaColuna + mat[i][j]
        }
      }
    }

  escreva("Soma primeira linha = " + somaPrimeiraLinha + "\n")
  escreva("Soma segunda coluna = " + somaSegundaColuna + "\n")
  }
}