
import { useState } from 'react'
import './App.css'
import Carro from './components/Carro'

function App() {
  const [contador, setContador] = useState(0)
  const [vendido, setVendido] = useState(false)
  const [list, setList] = useState([])

  const adicionarContador = () => {
    // setContador(contador+1)
    setContador((valorAtual) => valorAtual + 1)
  }

  return (
    <>
      <h1>Contador: {contador}</h1>
      <button onClick={() => adicionarContador()}>+ adicionar</button>
      
      <hr />

      <Carro 
        modelo="Corolla" 
        fabricante="Toyota"  
        preco="120000"
        cor="preto"
        vendido={vendido}
      />
      <button onClick={() => setVendido((valorAtual) => !valorAtual)} >Vender carro</button>
    </>
  )
}

export default App
