import { useState } from 'react'
import './App.css'


function App() {
  const [nome, setNome] = useState("")
  const [lab, setLab] = useState("")
  const [dosagem, setDosagem] = useState()
  const [valor, setValor] = useState()

  const handleSubmit = (e) => {
    e.preventDefault()
    alert(`\nNome: ${nome}\n
    Laboratório: ${lab}\n
    Dosagem: ${dosagem}\n
    Valor: R$ ${valor}`)
  }

  return (
    <>
      <h2>Nome: {nome}, Laboratório: {lab}, Dosagem: {dosagem}, Valor: R$ {valor}</h2>
      <form onSubmit={handleSubmit}>

        <input type="text"
          value={nome} onChange={(e) => setNome(e.target.value)} />
        <input type="text"
          value={lab} onChange={(e) => setLab(e.target.value)} />
        <input type="text"
          value={dosagem} onChange={(e) => setDosagem(e.target.value)} />
        <input type="text"
          value={valor} onChange={(e) => setValor(e.target.value)} />
        <input type="submit" />
      </form>

    </>
  )
}

export default App