import { useEffect, useState } from 'react'
import './App.css'
import Card from './components/Card'
import { CounterContextProvider } from "./context/CounterContext"
import ListagemEnderecos from './components/ListagemEnderecos'
import { EnderecosContextProvider } from './context/EnderecosContext'
import CardAdicionarEndereco from './components/CardAdicionarEndereco'

function App() {
  return (
    // <CounterContextProvider>
    //   <Card />
    // </CounterContextProvider>
    <>
      <EnderecosContextProvider>
        <CardAdicionarEndereco />
        <ListagemEnderecos />
      </EnderecosContextProvider>
    </>
  )
}

export default App
