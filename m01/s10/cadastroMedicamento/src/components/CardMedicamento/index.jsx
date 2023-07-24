import { useContext } from "react"
import { MedicamentoContext } from "../../context/MedicamentoContext"

function CardMedicamento({medicamento}) {
  const { FavoritarMedicamento } = useContext(MedicamentoContext)

  return (
    <div>
      <button onClick={() => FavoritarMedicamento(medicamento.id)}>{medicamento.favorito.toString()}</button>
      <img 
        width={150}
        src="https://img.freepik.com/vetores-premium/frasco-de-medicamento-em-branco-com-caixa-realista_134452-15.jpg?w=2000"
        alt="Imagem do medicamentoe" 
      />
      <h4>Medicamento: {medicamento.nome}</h4>
      <h4>Laboratório: {medicamento.laboratorio}</h4>
      <h4>Preço: R$ {medicamento.preco}</h4>
    </div>
  )
}

export default CardMedicamento