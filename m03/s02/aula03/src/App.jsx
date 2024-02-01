import { useEffect, useState } from 'react'
import './App.css'

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
      <button onClick={() => handleAdvice(advice)}>Add Advice</button>
      <div>
        {adviceList.map((advice, key) => (
          <p key={key}>{`${key + 1} - ${advice}`}</p>
        ))}
      </div>
    </main>
  )
}

export default App
