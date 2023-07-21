import { useState, useContext, useEffect } from "react"
import { EnderecosContext } from "../context/EnderecosContext"

function CardAdicionarEndereco() {

  const {listaEndereco, setListaEndereco}  = useContext(EnderecosContext)

  const [cep, setCep] = useState("")
  const [logradouro, setLogradouro] = useState("")
  const [numero, setNumero] = useState('')
  const [cidade, setCidade] = useState("")
  const [estado, setEstado] = useState("")

  useEffect(() => {
    if (listaEndereco.length == 0) {
      return
    }
    alert("Endereço adicionado com sucesso.")
  }, [listaEndereco])

  const salvarEndereco = (evento) => {
    evento.preventDefault()
    const endereco = {
      cep: cep,
      logradouro: logradouro,
      numero: numero,
      cidade: cidade,
      estado: estado
    }
    const novaLista = [...listaEndereco]
    novaLista.push(endereco)

    setListaEndereco(novaLista)
  }

  return (
    <form className="form" onSubmit={salvarEndereco} >
      <input type="text" value={cep} onChange={(e) => setCep(e.target.value)} placeholder='CEP' />
      <input type="text" value={logradouro} onChange={(e) => setLogradouro(e.target.value)} placeholder='Rua' />
      <input type="text" value={numero} onChange={(e) => setNumero(e.target.value)} placeholder='numero' />
      <input type="text" value={cidade} onChange={(e) => setCidade(e.target.value)} placeholder='cidade' />
      <input type="text" value={estado} onChange={(e) => setEstado(e.target.value)} placeholder='estado' /><button type='submit'>Salvar</button>
    </form>
  )
}

export default CardAdicionarEndereco
