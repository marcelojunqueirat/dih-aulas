import PropTypes from "prop-types"

function EmployeeListItem({imagem, imagemDescricao = "Foto Funcionário", nome, cargo, idade, endereco}){
  return (
    <>
      <img src={imagem} alt={imagemDescricao} />
      <h1>{nome}</h1>
      <h2>{cargo}</h2>
      <h2>{idade}</h2>
      <div>
        <p>Rua: {endereco.rua}</p>
        <p>Numero: {endereco.numero}</p>
      </div>
    </>
  )
}

// aqui vamos tipar as props
EmployeeListItem.propTypes = {
  imagem: PropTypes.string,
  nome: PropTypes.string,
  cargo: PropTypes.string,
  idade: PropTypes.number,
  endereco: PropTypes.shape({
    rua: PropTypes.string,
    numero: PropTypes.number
  })
}

export default EmployeeListItem;