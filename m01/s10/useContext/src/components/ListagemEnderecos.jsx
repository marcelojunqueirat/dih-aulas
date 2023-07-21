import { useContext } from "react"
import { EnderecosContext } from '../context/EnderecosContext'
import Endereco from "./Endereco"

function ListagemEnderecos(){
  const {listaEndereco}= useContext(EnderecosContext)

  return (
    <>
      {listaEndereco.map((item, index) => (
        <Endereco key={index} item={item} />
      ))}
    </>
  )
}

export default ListagemEnderecos