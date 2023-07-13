import Cabecalho from "./Cabecalho";

function Card(props) {
  return (
    <div>
      <Cabecalho texto={props.titulo} />
      <h3>{props.subtitulo}</h3>
      <p>{props.valor}</p>
    </div>
  )
}

export default Card