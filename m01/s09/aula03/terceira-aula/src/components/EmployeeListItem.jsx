function EmployeeListItem({imagem, imagemDescricao = "Foto Funcionário", nome, cargo}){
  return (
    <>
      <img src={imagem} alt={imagemDescricao} />
      <h1>{nome}</h1>
      <h2>{cargo}</h2>
    </>
  )
}

export default EmployeeListItem;