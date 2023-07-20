import { useReducer, useState } from 'react'
import './App.css'

function App() {

  const funcaoRedutora = (state, action) => {
    switch (action.type) {
      case "SOMAR":
        return state + 1
      case "SUBTRAIR":
        return state - 1
      default:
        return state
    }
  }

  const [numero, dispatchNumero] = useReducer(funcaoRedutora, 0)

  return (
    <>
      <h1>{numero}</h1>
      <button onClick={() => dispatchNumero({ type: "SOMAR" })} >Somar</button>
      <button onClick={() => dispatchNumero({ type: "SUBTRAIR" })} >Subtrair</button>
    </>
  )
}

export default App
