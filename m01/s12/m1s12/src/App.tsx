import { BrowserRouter } from 'react-router-dom'
import { RoutesApp } from './routes'
import { AppProvider } from './context'

function App() {

  return (
    <BrowserRouter>
      <AppProvider>
        <RoutesApp />
      </AppProvider>
    </BrowserRouter>
  )
}

export default App
