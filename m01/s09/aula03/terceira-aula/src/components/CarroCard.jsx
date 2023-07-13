function CarroCard({modelo, fabricante, numPortas = 4, cor, valor, fotoVeiculo}) {
  return (
    <>
      <img src={fotoVeiculo} alt={`Foto do veículo ${modelo}`} width={300} height={200} />
      <h2>Modelo: {modelo}</h2>
      <h3>Fabricante: {fabricante}</h3>
      <h3>Nº de portas: {numPortas}</h3>
      <h3>Cor: {cor}</h3>
      <h3>Valor: {valor}</h3>
    </>
  )
}

export default CarroCard