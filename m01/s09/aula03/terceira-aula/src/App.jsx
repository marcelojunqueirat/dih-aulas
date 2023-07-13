import './App.css'
import Card from './components/Card'
import EmployeeListItem from './components/EmployeeListItem'
import CarroCard from './components/CarroCard'

function App() {
  const funcionariosList = [
    {
      nome: 'Jonh Legend',
      cargo: 'cantor',
      idade: 27,
      imagem: "https://avatars.githubusercontent.com/u/47543726?v=4",
      endereco: {
        rua: 'Rua 2',
        numero: 25
      }
    },
    {
      nome: 'Marcelo',
      cargo: 'dev',
      idade: 27,
      imagem: "https://avatars.githubusercontent.com/u/47543726?v=4",
      endereco: {
        rua: 'Rua 3',
        numero: 25
      }
    }
  ]

  return (
    <>
      {/* <EmployeeListItem 
        idade={27} 
        nome="James King" 
        cargo="Presidente e CEO" 
        imagem="https://avatars.githubusercontent.com/u/47543726?v=4" 
        endereco={{rua: "Rua 1", numero: 25}}
      />
      <Card valor={10} titulo="Titulo do Card Modificado" subtitulo="Subtitulo do meu card" />
      <Card titulo="Titulo do Card 2" />
      <CarroCard modelo="Astra" fabricante="GM" numPortas={2} cor="Prata" valor="R$30.000,00" fotoVeiculo="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fblog.jocar.com.br%2Fwp-content%2Fuploads%2F2019%2F04%2Fautowp.ru_chevrolet_astra_ss_2.0_flexpower_2.jpg&f=1&nofb=1&ipt=1935b4d0c10583e274d912a0c00c3b996359ff0e95942c3a04733c276cad3fb4&ipo=images" />
      <CarroCard modelo="Vectra" fabricante="GM" cor="Preto" valor="R$35.000,00" fotoVeiculo="https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2F2.bp.blogspot.com%2F-ujsctbxOpz0%2FVJeaPGOXF_I%2FAAAAAAAB904%2FnrNMMgwX5zk%2Fs1600%2FChevrolet-Vectra-2009%252B(7).jpg&f=1&nofb=1&ipt=02126e0e0aa4b5fcb82a9345388358e092d62932799870ff0ffbb8a04e2e9283&ipo=images" /> */}

      {/* Imprimindo uma lista */}
      {funcionariosList.map((funcionario, index) => (
        <EmployeeListItem 
          imagem={funcionario.imagem}
          nome={funcionario.nome}
          idade={funcionario.idade}
          cargo={funcionario.cargo}
          endereco={funcionario.endereco}
          key={index}
        />
      ))}
    </>
  )
}

export default App
