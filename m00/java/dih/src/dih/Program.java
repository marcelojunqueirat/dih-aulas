package dih;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double autonomiaVeiculoTanqueCheio = 700.0;

		System.out.print("Informe em KM a distância da cidade para realizar a entrega: ");
		double km = sc.nextDouble();

		System.out.println(validacaoDistancia(autonomiaVeiculoTanqueCheio, km));
		sc.close();
	}

	public static String validacaoDistancia(double autonomia, double km) {
		if (km > autonomia) {
			return "Combustivel nao sera suficiente para o trajeto. Sera preciso abastecer no caminho.";
		} else if ((km * 2) > autonomia) {
			return "Combustivel nao sera suficiente para o trajeto de ida e volta. Sera preciso abastecer no caminho.";
		} else {
			return "Combustivel suficiente para realizar o trajeto";
		}
	}
}
