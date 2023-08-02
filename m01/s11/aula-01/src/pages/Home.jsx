import { Header } from '../components/Header'
import { Footer } from '../components/Footer'
import { Main } from '../components/Main'

function Home() {
  return (
    <>
      <Header />
      <Main>
        <p>Home</p>
      </Main>
      <Footer />
    </>
  )
}

export { Home }