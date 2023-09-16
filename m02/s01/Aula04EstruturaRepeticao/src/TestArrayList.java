import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Marcelo1");
        nomes.add("Marcelo2");
        nomes.add("Marcelo3");
        nomes.add("Marcelo4");
        nomes.add("Marcelo5");

        nomes.add(0,"Marcelo6");

        for (String nome : nomes){
            System.out.println(nome);
        }

        System.out.println(nomes.size());

        String nome = nomes.get(4);
        System.out.println(nome);

        System.out.println(nomes);
        System.out.println(nomes.contains("Marcelo5"));

        nomes.remove("Marcelo5");
        System.out.println(nomes.contains("Marcelo5"));
        System.out.println(nomes);

        Collections.sort(nomes);
        System.out.println(nomes);

        System.out.println(Collections.min(nomes));
        System.out.println(Collections.max(nomes));

        Collections.reverse(nomes);
        System.out.println(nomes);

        ArrayList<Integer> anosDeCopa =new ArrayList<>();


    }
}
