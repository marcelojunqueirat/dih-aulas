import { useEffect, useState } from 'react'
import './App.css'
import { Button } from './components/Button'
import { AdviceCard } from './components/AdviceCard'

function App() {
  const [adviceList, setAdiviceList] = useState([])
  const [advice, setAdvice] = useState('')

  useEffect(() => {
    fetch('https://api.adviceslip.com/advice')
    .then(response => response.json())
    .then(data => setAdvice(data.slip.advice))
    .catch(error => console.error(error))
  }, [adviceList])

  const handleAdvice = (advice) => {
    const newUpdatedList = [...adviceList, advice]
    setAdiviceList(newUpdatedList)
  }

  return (
    <main>
      <Button title={"Add Advice"} onClick={() => handleAdvice(advice)} />
      <AdviceCard list={adviceList} />
    </main>
  )
}

export default App
