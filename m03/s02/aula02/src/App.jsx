import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [joke, setJoke] = useState(null)
  const [newJoke, setNewJoke] = useState(0)

  useEffect(() => {
    fetch('https://api.chucknorris.io/jokes/random')
      .then(response => response.json())
      .then(data => setJoke(data.value))
      .catch(error => console.error(error))
  }, [newJoke])

  return (
    <>
      <h3>Welcome to Chuck Norris Jokes</h3>
      <h2>{joke && joke}</h2>
      <button onClick={() => setNewJoke(newJoke + 1)}>New Joke?</button>
    </>
  )
}

export default App
