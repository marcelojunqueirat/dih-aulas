import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import { MedicamentoContextProvider } from './context/MedicamentoContext.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <MedicamentoContextProvider>
    <App />
  </MedicamentoContextProvider>
)
