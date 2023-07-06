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
    },
    {
      "nome": "Salada Caesar",
      "ingredientes": [
        "2 corações de alface romana",
        "1 xícara de croutons",
        "1/2 xícara de queijo parmesão ralado",
        "1/4 de xícara de molho Caesar",
        "1 colher de chá de suco de limão",
        "1 colher de chá de mostarda dijon",
        "1 dente de alho picado",
        "2 filés de frango grelhados, cortados em tiras"
      ],
      "instrucoes": [
        "Lave e seque bem os corações de alface romana e rasgue as folhas em pedaços menores.",
        "Em uma tigela grande, misture o molho Caesar, o suco de limão, a mostarda e o alho.",
        "Adicione a alface rasgada à tigela e misture bem para cobrir as folhas com o molho.",
        "Adicione os croutons e o queijo parmesão e misture novamente.",
        "Divida a salada em pratos individuais e coloque as tiras de frango grelhado por cima.",
        "Sirva imediatamente."
      ],
      "imagem": "https://marolacomcarambola.com.br/wp-content/uploads/2019/08/Receita-de-Salada-Caesar-Caesar-Salad-1.jpg"
    },
    {
      "nome": "Pizza Margherita",
      "ingredientes": [
        "1 massa de pizza pré-cozida",
        "1 xícara de molho de tomate",
        "200g de queijo muçarela fatiado",
        "Folhas de manjericão fresco",
        "Azeite de oliva",
        "Sal e pimenta a gosto"
      ],
      "instrucoes": [
        "Pré-aqueça o forno de acordo com as instruções da massa de pizza.",
        "Espalhe o molho de tomate uniformemente sobre a massa.",
        "Coloque as fatias de queijo muçarela por cima do molho de tomate.",
        "Tempere com sal e pimenta a gosto e regue com um fio de azeite de oliva.",
        "Asse no forno conforme as instruções da massa de pizza, ou até que o queijo esteja derretido e a massa esteja dourada.",
        "Retire do forno e coloque algumas folhas de manjericão fresco por cima.",
        "Corte em fatias e sirva quente."
      ],
      "imagem": "https://anamariabraga.globo.com/wp-content/uploads/2020/08/pizza-margherita.jpg"
    }
  ]
`
let receitasLista = JSON.parse(receitas);
let receitaElement = document.querySelector('#receita');
let pagina = 0;

renderizaReceitas()

function renderizaReceitas() {
  let h1Element = document.createElement('h1');
  h1Element.innerText = receitasLista[pagina].nome;
  receitaElement.appendChild(h1Element)

  let ingredientes = document.createElement('h2');
  ingredientes.innerText = 'Ingredientes';
  receitaElement.appendChild(ingredientes);

  receitasLista[pagina].ingredientes.map((ingrediente) => {
    let liElement = document.createElement('li');
    liElement.innerText = ingrediente;
    receitaElement.appendChild(liElement)
  })

  let instrucoes = document.createElement('h2');
  instrucoes.innerText = 'Instruções';
  receitaElement.appendChild(instrucoes);


  receitasLista[pagina].instrucoes.map((instrucao) => {
    let liInstrucoesElement = document.createElement('li');
    liInstrucoesElement.innerText = instrucao;

    receitaElement.appendChild(liInstrucoesElement)
  })

  let imagem = document.createElement('img');
  imagem.setAttribute('src', receitasLista[pagina].imagem)
  receitaElement.appendChild(imagem);
}

function exibirProximaPagina(){
  if (pagina === receitasLista.length - 1){
    return;
  }
  receitaElement.innerHTML ="";
  ++pagina;
  renderizaReceitas();
}

function exibirPaginaAnterior(){
  if (pagina === 0){
    return;
  }
  receitaElement.innerHTML ="";
  --pagina;
  renderizaReceitas();
}

