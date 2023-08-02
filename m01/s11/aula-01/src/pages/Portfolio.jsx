import { Footer } from '../components/Footer'
import { Header } from '../components/Header'
import { Main } from '../components/Main'
import { useEffect, useState } from 'react'
import { api } from '../services/api'

function Portfolio() {
  const [repos, setRepos] = useState([])

  useEffect(() => {
    const load = async () => {
      const response = await api.get("users/marcelojunqueirat/repos")
      setRepos(response.data)
    }
    load()
  }, [])

  return (
    <>
      <Header />
      <Main>
        <p>Portfolio</p>
        <ul>
          {
            repos.length > 0 && repos.map(({html_url, name}) => (
              <li key={name}>{name}</li>
            ))
          }
        </ul>
      </Main>
      <Footer />
    </>
  )
}

export { Portfolio }