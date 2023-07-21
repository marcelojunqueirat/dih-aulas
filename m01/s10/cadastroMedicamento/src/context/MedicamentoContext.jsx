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

  return (
    <MedicamentoContext.Provider value={{listaMedicamentos, setListaMedicamentos}}>
      {children}
    </MedicamentoContext.Provider>
  )
}