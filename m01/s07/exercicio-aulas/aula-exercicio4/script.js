let btn = document.querySelectorAll('.btn');

for (const botao of btn) {
  if(botao.hasAttribute('disabled')){
    botao.removeAttribute('disabled')
  }

  botao.style.padding = "20px";
  botao.style.backgroundColor = "darkblue";
  botao.style.color = "white";
  botao.style.fontSize = "large";

  if(botao.classList.contains('destaque')){
    botao.classList.remove('destaque');
  }
}

