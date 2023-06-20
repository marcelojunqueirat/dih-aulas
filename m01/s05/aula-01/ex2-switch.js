var formaPagamento = "PIX";
switch (formaPagamento) {
    case "AVISTA":
    case "BOLETO":
    case "1XCARTAO":
        console.log("Desconto de 5%");
        break;
    default:
        console.log("Sem desconto");
}
