import { HeaderStyled } from './styled'
import { Link } from 'react-router-dom'

function Header() {
  const pages = [
    {
      route: "/",
      description: "Home"
    },
    {
      route: "/aboutme",
      description: "About me"
    }
  ]

  return (
    <HeaderStyled>
      <nav>
        {
          pages.map(({ route, description }) => (
            <Link key={description} to={route}>
              {description}
            </Link>
          )
          )
        }
      </nav>
    </HeaderStyled>
  )
}

export { Header }