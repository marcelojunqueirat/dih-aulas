import { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import { Header } from '../../components/Header'
import { Footer } from '../../components/Footer'
import { Main } from '../../components/Main'
import { api } from '../../services/api'
import { HomeUlStyled, HomeLiStyled, HomeImgStyled } from './styled'

function Home() {
  const [users, setUsers] = useState([])

  useEffect(() => {
    const load = async () => {
      const response = await api.get("users")
      setUsers(response.data)
    }
    load()
  }, [])

  return (
    <>
      <Header />
      <Main>
        <p>Home</p>
        <HomeUlStyled>
          {
            users.length > 0 && users.map(({ login, avatar_url }) => (
              <HomeLiStyled key={login}>
                <p>{login}</p>
                <HomeImgStyled src={avatar_url} alt={`Foto do ${login}`} />
                <Link to={`portfolio/${login}`}>
                  Venha ver meu portfolio
                </Link>
              </HomeLiStyled>
            ))
          }
        </HomeUlStyled>
      </Main>
      <Footer />
    </>
  )
}

export { Home }