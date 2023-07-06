let dados = `[
  {
    "id": 1,
    "nome": "marcelo",
    "email": "teste@teste.com",
    "admin": true
  },
  {
    "id": 2,
    "nome": "maria",
    "email": "maria@teste.com",
    "admin": true
  }
]`

let listaUsuarios = JSON.parse(dados);

listaUsuarios.push({
  nome:"Joao",
  id: 3,
  email: "pedro@teste.com",
  admin: false
})

dados = JSON.stringify(listaUsuarios)

console.log(dados);

const divPrincipal = document.querySelector('#principal');

function renderizarUsuario(){
  listaUsuarios.map((usuario) => {
    const h2 = document.createElement('h2');
    h2.innerText = usuario.nome;

    const span = document.createElement('span');
    span.innerText = usuario.email;

    divPrincipal.appendChild(h2);
    divPrincipal.appendChild(span);
  })
}

renderizarUsuario()