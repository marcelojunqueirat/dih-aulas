import { useState, useEffect } from 'react'
import './App.css'
import axios from 'axios'

function App() {
  const [ususario, setUsuario] = useState({})

  // COM FETCH
  // useEffect(() => {
  //   fetch("https://api.github.com/users/marcelojunqueirat")
  //     .then((resposta) => {
  //       return resposta.json()
  //     })
  //     .then((dados) => {
  //       setUsuario(dados)
  //     })
  //     .catch((error) => console.log(error))
  // }, [])

  // COM ASYNC E AWAIT
  // useEffect(() => {
  //   const fetchDados = async () => {
  //     try {
  //       const resultado = await fetch("https://api.github.com/users/marcelojunqueirat")

  //       if (resultado.status === 200) {
  //         const dados = await resultado.json();
  //         setUsuario(dados)
  //         console.log(dados);
  //       }
  //     } catch (error) {
  //       console.log(error);
  //     }
  //   }

  //   fetchDados()
  // }, [])

  // COM AXIOS
  useEffect(() => {
    const fetchDados = async () => {
      try {
        const resultado = await axios.get("https://api.github.com/users/marcelojunqueirat")
        if (!!resultado.data) {
          setUsuario(resultado.data)
        }
      } catch (error) {
        console.log(error);
      }
    }

    fetchDados()
  }, [])

  return (
    <>
      <h1>Nome do usuário: {ususario?.name}</h1>
    </>
  )
}

export default App
