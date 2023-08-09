import { createContext } from "react"
import { useLocalStorage } from "../hooks/useLocalStorage"

const AppContext = createContext()

function AppProvider({ children }) {
  const {value, setValue} = useLocalStorage("user", {})

  return (
    <AppContext.Provider value={{value, setValue}}>
      {children}
    </AppContext.Provider>
  )
}

export { AppProvider, AppContext }