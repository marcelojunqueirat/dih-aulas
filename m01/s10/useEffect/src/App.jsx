import { useEffect, useRef, useState } from 'react'
import './App.css'

function App() {
  const [count, setCount] = useState(0)
  const [count2, setCount2] = useState(0)
  const numero = useRef(0)
  const [cor, setCor] = useState('green')

  const div = useRef()

  // useEffect(() => {
  //   alert("Renderização a qualquer alteração")
  // })

  // useEffect(() => {
  //   alert("Renderização apenas Inicial")
  // }, [])

  // useEffect(() => {
  //   alert("Renderização incial e quando acionar o count")
  //   numero.current += 1
  // }, [count])

  const atualizaCount = () => {
    setCount2(count2 + 1)
    numero.current += 1
  }

  useEffect(() => {
    div.current.style.backgroundColor = cor
  })

  return (
    <>
      <h1>Contador: {count} <br /></h1>
      <button onClick={() => setCount(count + 1)} >+ adicionar</button>

      <h1>Contador 2: {count2} <br /></h1>
      <button onClick={() => atualizaCount()} >+ adicionar</button>

      <h1>Ref: {numero.current}</h1>

      <div ref={div} style={{ width: '200px', height: '200px' }}>DIV</div>
      <button onClick={() => setCor("red")}>vermelho</button>
      <button onClick={() => setCor("yellow")}>amarelo</button>
      <button onClick={() => setCor("green")}>verde</button>
    </>
  )
}

export default App
