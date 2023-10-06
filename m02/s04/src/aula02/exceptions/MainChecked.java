package aula02.exceptions;

public class MainChecked {

    public static void main(String[] args) {

        Integer nota = 10;
        Integer adicional = 2;

        try {
            Integer notaFinal = calcularNota(nota, adicional);
            System.out.println("Nota final " + notaFinal);
        } catch (NotaExcedidaException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("A nota do aluno ficou superior a 10, favor reavaliar");
        }

    }

    private static Integer calcularNota(Integer nota, Integer adicional) throws NotaExcedidaException {
        Integer resultado = nota + adicional;
        if (resultado > 10)
            throw new NotaExcedidaException("Nota maior que 10!!!");  // checked
        else if (resultado < 0)
            throw new NotaMenorQueZeroException(); // unchecked

        return resultado;
    }

}
