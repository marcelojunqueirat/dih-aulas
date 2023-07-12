import './App.css'
import Card from './components/Card'

function App() {
  const usuario = { nome: "Marcelo", turma: "Clamed V2" }

  return (
    <>
      <h1>Nome: {usuario.nome}</h1>
      <h2>Turma: {usuario.turma}</h2>
      <Card />
    </>
  )
}

export default App
