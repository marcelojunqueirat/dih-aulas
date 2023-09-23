package EX4;

public class TestaFatura {
    public static void main(String[] args) {
        Fatura fatura = new Fatura("124", "Venda de 5 itens", 5, 20.39);
        System.out.println(fatura.getValorFatura());
    }
}
