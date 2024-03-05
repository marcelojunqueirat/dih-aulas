import './style.css'
function Card({list}) {
  console.log(list)
  return (
    <ul>
      {list.map((item, i) => (
        <li key={i}>
          <div className="perfil-data">
            <img className="perfil-photo" src={item.foto_perfil} alt={item.criador} />
            {item.nome}
            <span>{item.nickcriador}</span>
          </div>
          <img src={item.imagem} alt={item.categoria} />

          <div>
            <div>R$ {item.precoreal}</div>
            <b>{item.preco} {item.moeda}</b>
          </div>
        </li>
      ))}
    </ul>
  )
}

export default Card;