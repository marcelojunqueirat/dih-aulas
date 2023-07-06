const receitas = `
  [
    {
      "nome": "Bolo de Chocolate",
      "ingredientes": [
        "2 xícaras de farinha de trigo",
        "1 xícara de açúcar",
        "1/2 xícara de cacau em pó",
        "1 colher de sopa de fermento em pó",
        "1 colher de chá de sal",
        "1 xícara de leite",
        "1/2 xícara de óleo vegetal",
        "2 ovos",
        "1 colher de chá de extrato de baunilha",
        "1 xícara de água fervente"
      ],
      "instrucoes": [
        "Preaqueça o forno a 180°C.",
        "Em uma tigela grande, misture a farinha, o açúcar, o cacau em pó, o fermento e o sal.",
        "Adicione o leite, o óleo vegetal, os ovos e a baunilha à mistura seca e bata até obter uma massa homogênea.",
        "Adicione a água fervente e misture bem.",
        "Despeje a massa em uma forma untada e asse por cerca de 30-35 minutos, ou até que um palito inserido no centro do bolo saia limpo.",
        "Deixe o bolo esfriar antes de desenformar.",
        "Decore como desejar e sirva."
      ],
      "imagem": "https://static.itdg.com.br/images/1200-630/bd14ed0d98530fb34b6f60a295382a7a/348000-original.jpg"
    }
  ]
`
let receitasLista = JSON.parse(receitas);

let bodyElement = document.querySelector('body');
console.log(bodyElement);

function renderizaReceitas() {
  receitasLista.map((receita) => {
    let h1Element = document.createElement('h1');
    h1Element.innerText = receita.nome;
    bodyElement.appendChild(h1Element)

    let ingredientes = document.createElement('h2');
    ingredientes.innerText = 'Ingredientes';
    bodyElement.appendChild(ingredientes);

    receita.ingredientes.map((ingrediente) => {
      let liElement = document.createElement('li');
      liElement.innerText = ingrediente;

      bodyElement.appendChild(liElement)
    })

    let instrucoes = document.createElement('h2');
    instrucoes.innerText = 'Instruções';
    bodyElement.appendChild(instrucoes);

    receita.instrucoes.map((instrucao) => {
      let liInstrucoesElement = document.createElement('li');
      liInstrucoesElement.innerText = instrucao;

      bodyElement.appendChild(liInstrucoesElement)
    })

    let imagem = document.createElement('img');
    imagem.setAttribute('src', receita.imagem)
    bodyElement.appendChild(imagem);
    console.log(receita.imagem);

  })
}

renderizaReceitas()
