function Carro({modelo, fabricante, cor, preco, vendido, numPortas = 4}) {
  return(
    <div>
      {/* <h3>{vendido && 'Vendido'}</h3> */}
      <h3>{(vendido) ? 'Vendido' : 'Não Vendido'}</h3>
      <h1>
        Modelo: {modelo}
      </h1>
      <h2>Fabricante: {fabricante}</h2>
      <h2>Cor: {cor}</h2>
      <h2>Preço: {preco}</h2>
      <h2>N° Portas: {numPortas}</h2>
    </div>
  )

}

export default Carro