import { useContext } from 'react'
import { CounterContext } from '../context/CounterContext'

function Card() {
  const { count, setCount } = useContext(CounterContext)
  const { count2, setCount2 } = useContext(CounterContext)

  return (
    <div>
      <h1>{count}</h1>
      <button onClick={() => setCount(count + 1)} > Adicionar </button>
      <h1>{count2}</h1>
      <button onClick={() => setCount2(count2 - 1)} > Subtrair </button>
    </div>
  )
}

export default Card