import { MainStyled } from './styled'

function Main ({children}) {
  return(
    <MainStyled>
      {children}
    </MainStyled>
  )
}

export { Main }