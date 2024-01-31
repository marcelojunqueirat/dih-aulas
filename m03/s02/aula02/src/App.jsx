import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [joke, setJoke] = useState(null)
  const [newJoke, setNewJoke] = useState(0)

  const [user, setUser] = useState({})
  const [userName, setUsername] = useState('marcelojunqueirat')
  const [search, setSearch] = useState('')

  useEffect(() => {
    fetch('https://api.chucknorris.io/jokes/random')
      .then(response => response.json())
      .then(data => setJoke(data.value))
      .catch(error => console.error(error))
  }, [newJoke])

  useEffect(() => {
    fetch(`https://api.github.com/users/${userName}`)
      .then(response => response.json())
      .then(data => setUser(data))
      .catch(error => console.error(error))
  }, [userName])

  return (
    <>
      <h3>Welcome to Chuck Norris Jokes</h3>
      <h2>{joke && joke}</h2>
      <button onClick={() => setNewJoke(newJoke + 1)}>New Joke?</button>

      <hr />

      <input placeholder="Usuário" type="text" onChange={(event) => setSearch(event.target.value)} />
      <button onClick={() => setUsername(search)}>Buscar</button>

      <div>
        <img id='avatar' src={user.avatar_url} alt={user.name} />
      </div>

      <h3>{user.name}</h3>
      <h4>{user.bio}</h4>
      <h4>Seguindo: {user.following}</h4>
      <h4>Seguidores: {user.followers}</h4>
      <h4>{user.location}</h4>
    </>
  )
}

export default App
