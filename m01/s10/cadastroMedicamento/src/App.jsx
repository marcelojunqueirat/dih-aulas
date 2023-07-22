import Header from './components/Header'
import FormularioNovoMedicamento from './components/FormularioNovoMedicamento'
import CardMedicamento from './components/CardMedicamento'

import { MedicamentoContext } from './context/MedicamentoContext'
import { useContext } from 'react'

function App() {
  const {listaMedicamentos} = useContext(MedicamentoContext)

  return (
    <>
      <Header />
      <FormularioNovoMedicamento />
      {listaMedicamentos.map(medicamento => (
        <CardMedicamento key={medicamento.id} medicamento={medicamento} />
      ))}
    </>
  )
}

export default App
