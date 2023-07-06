import dados from "./usuarios.json" assert {type: 'json'}

console.log(dados);

const divPrincipal = document.querySelector('#principal');

const usuarios = dados.usuarios;

function renderizarUsuario(){
  usuarios.map((usuario) => {
    const h2 = document.createElement('h2');
    h2.innerText = usuario.nome;

    const span = document.createElement('span');
    span.innerText = usuario.email;

    divPrincipal.appendChild(h2);
    divPrincipal.appendChild(span);
  })
}

renderizarUsuario()