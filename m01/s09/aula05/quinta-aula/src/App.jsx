import { useState } from 'react'
import './App.css'
import CardAdicionar from './components/CardAdicionar'

function App() {
  const [listaTarefas, setListaTarefas] = useState([
    { id: 1, textoTarefa: "Tarefa 1", finalizado: false }
  ])

  const adicionarTarefa = (texto) => {
    if(texto == ""){
      alert("É necessário escrever uma tarefa.")
      return
    }

    const novaTarefa = { id: listaTarefas.length + 1, textoTarefa: texto, finalizado: false }

    // setListaTarefas((dadosAtuais) => [...dadosAtuais, novaTarefa] )
    setListaTarefas([...listaTarefas, novaTarefa])
  }

  return (
    <>
      <CardAdicionar adicionarTarefa={adicionarTarefa} />
      
      <div>{listaTarefas.map((tarefa, key) => (
        <p key={key}>{tarefa.textoTarefa}</p>
      ))}
      </div>
    </>
  )
}

export default App
