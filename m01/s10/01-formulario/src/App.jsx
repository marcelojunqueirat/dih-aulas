import { useState } from 'react'
import './App.css'

function App() {
  const [nome, setNome] = useState("")
  const [laboratotio, setLaboratorio] = useState("")
  const [dosagem, setDosagem] = useState("")
  const [valor, setValor] = useState("")

  const [listaMedicamentos, setListaMedicamentos] = useState([])

  const handleSubmit = (evento) => {
    evento.preventDefault()

    const medicamento = {
      nome,
      laboratotio,
      dosagem,
      valor
    }

    const novaLista = [...listaMedicamentos, medicamento]
    setListaMedicamentos(novaLista)

    // localStorage.setItem('medicamento', JSON.stringify(medicamento))
  }

  return (
    <>
      <h2>Medicamentos</h2>
      <form onSubmit={(evento) => handleSubmit(evento)}>
        {/* <form onSubmit={handleSubmit}> */}
        <input
          type="text"
          value={nome}
          onChange={(evento) => setNome(evento.target.value)}
        />
        <input
          type="text"
          value={laboratotio}
          onChange={(evento) => setLaboratorio(evento.target.value)}
        />
        <input
          type="text"
          value={dosagem}
          onChange={(evento) => setDosagem(evento.target.value)}
        />
        <input
          type="text"
          value={valor}
          onChange={(evento) => setValor(evento.target.value)}
        />

        <button type='submit'>Salvar</button>
      </form>

      {listaMedicamentos.map((medicamento, key) => (<p key={key}>{medicamento.nome}</p>))}
    </>
  )
}

export default App
