import { useState, useEffect } from 'react'
import './App.css'
import axios from 'axios'

function App() {
  const [endereco, setEndereco] = useState({})
  const [cep, setCep] =useState('01001000')

  const fetchDados = async (cep) => {
    if(cep.length != 8){
      alert('Cep precisa ter 8 digitos')
      return
    }
    try {
      const resultado = await axios.get(`https://viacep.com.br/ws/${cep}/json/`)
      if (!!resultado.data) {
        setEndereco(resultado.data)
      }
    } catch (error) {
      console.log(error);
    }
  }

  useEffect(() => {
    fetchDados()
  }, [])

  return (
    <>
      <div>
        <label htmlFor="cep">CEP: </label>
        <input id='cep' type="text" value={cep} onChange={(e) => setCep(e.target.value)}/>
        <button onClick={() => fetchDados(cep)}>Buscar CEP</button>
      </div>
      <h2>CEP: {endereco.cep}</h2>
      <h2>Logradouro: {endereco.logradouro}</h2>
      <h2>DDD: {endereco.ddd}</h2>
      <h2>Localidade: {endereco.localidade}</h2>
      <h2>UF: {endereco.uf}</h2>
      <h2>Código IBGE: {endereco.ibge}</h2>
    </>
  )
}

export default App