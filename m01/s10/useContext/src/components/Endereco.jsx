function Endereco({item}) {
  return (
    <div style={{marginBottom: '15px', backgroundColor: 'blueviolet', padding: '10px'}}>
      <h2> CEP: {item.cep}</h2>
      <h2> Rua: {item.logradouro}</h2>
      <h2> Número: {item.numero}</h2>
      <h2> Cidade: {item.cidade}</h2>
      <h2> Estado: {item.estado}</h2>
    </div>
  )
}

export default Endereco