/**
 * PASSOS PARA CRIAR UM CONTEXTO
 * 1 - [x] - importe o createContext do react
 * 2 - [x] - criar a variável do context
 *    obs: por padrão o contexto recebe o mesmo nome do arquivo
 *    obs2: lembre-se de exportar a variável do context
 * 3 - [x] - defina o provider
 *    3.1 - [x] - defina os dados globais
 *    3.2 - [x] - defina o value do provider
 *      obs: geralmente o value vai ser um objeto
 *      obs2: lembre-se de exportar a variável do Provider
 *    3.3 - [x] - defina o children
*/

import { createContext, useState } from 'react'

export const MedicamentoContext = createContext()

export const MedicamentoContextProvider = ({children}) => {
  const [listaMedicamentos, setListaMedicamentos] = useState([])

  const AdicionarMedicamento = (nome, laboratorio, preco) => {
    if(nome.length == '' || laboratorio.length == '' || preco == 0){
      alert('Preencha todas as informações!')
      return
    }

    const novoMedicamento = {
      id: listaMedicamentos.length +1,
      nome: nome,
      laboratorio: laboratorio,
      preco: preco,
      favorito: false
    }

    const novaLista = [...listaMedicamentos, novoMedicamento]
    // novaLista.push(novoMedicamento)
    setListaMedicamentos(novaLista)
    alert('Medicamento cadastrado com sucesso!')
    console.log(novaLista);
    localStorage.setItem("listaMedicamentos", JSON.stringify(novaLista))
  }

  const FavoritarMedicamento = (id) => {

    // // SOLUCAO 1
    // // procura medicamento a ser encontrado
    // const medicamento = listaMedicamentos.filter(item => item.id == id)
    
    // // valida se existe medicamento
    // if(medicamento.length == 0){
    //   return
    // }

    // //marcamos medicamento como favorito (ou nao)
    // medicamento.favorito = !medicamento.favorito

    // // pegamos toda a lista novamente sem o medicamento
    // const listaFiltrada = listaMedicamentos.filter(item => item.id != id)

    // // juntamos novamente toda a lista
    // const novaLista = [...listaFiltrada, medicamento]

    // // atualizamos a lista
    // setListaMedicamentos(novaLista)

    // SOLUCAO 2
    const lista = listaMedicamentos.map((item) => {
      if(item.id == id){
        item.favorito = !item.favorito
      }

      return item
    })

    setListaMedicamentos(lista)
  }

  return (
    <MedicamentoContext.Provider value={{listaMedicamentos, AdicionarMedicamento}}>
      {children}
    </MedicamentoContext.Provider>
  )
}