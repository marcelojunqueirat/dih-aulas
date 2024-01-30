import { useState } from 'react'
import './App.css'

function App() {
  const [tarefa, setTarefa] = useState();
  const [listaTarefas, setListaTarefas] = useState([]);

  const adicionarTarefa = (tarefa) => {
    const listaTarefasAtualizada = [...listaTarefas, tarefa]
    setListaTarefas(listaTarefasAtualizada)
  }

  const removerTarefa = (tarefa) => {
    setListaTarefas(listaTarefas.filter(listaTarefa => listaTarefa != tarefa))
  }

  return (
    <>
      <label htmlFor="tarefa">Tarefa: </label>
      <input
        name="tarefa"
        type="text"
        onChange={(event) => setTarefa(event.target.value)}
      />
      <button onClick={() => adicionarTarefa(tarefa)}>Adicionar</button>

      {listaTarefas.map((tarefa, id) => (
        <div key={id}>
          <li>{tarefa}</li>
          <button onClick={() => removerTarefa(tarefa)}>Remover</button>
        </div>
      ))}
    </>
  )
}

export default App
