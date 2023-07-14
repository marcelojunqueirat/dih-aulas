import { useState } from "react"

function CardAdicionar(props) {
  const [textoTarefa, setTextoTarefa] = useState("")

  return (
    <>
      {/* <h1>{textoTarefa}</h1> */}
      <input
        placeholder="Adicionar tarefa"
        type="text"
        value={textoTarefa}
        onChange={ (evento) => {setTextoTarefa(evento.target.value)} }
      />
      <button onClick={() => props.adicionarTarefa(textoTarefa)} >Adicionar</button>
    </>
  )
}


export default CardAdicionar