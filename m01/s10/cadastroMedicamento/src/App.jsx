import { useState } from 'react'

import { MedicamentoContextProvider } from './context/MedicamentoContext'

import Header from './components/Header'
import FormularioNovoMedicamento from './components/FormularioNovoMedicamento'

function App() {

  return (
    <>
      <Header />
      <MedicamentoContextProvider>
        <FormularioNovoMedicamento />
      </MedicamentoContextProvider>
    </>
  )
}

export default App
