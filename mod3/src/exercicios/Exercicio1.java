package exercicios;

import java.util.ArrayList;
import java.util.List;

public class Exercicio1 {

    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        int n = 1;

        List<List<Integer>> resultado = gerarSubconjuntos(S, n);
        System.out.println(resultado);
    }

    public static List<List<Integer>> gerarSubconjuntos(int[] S, int n) {
        List<List<Integer>> resultado = new ArrayList<>();
        List<Integer> subconjuntoAtual = new ArrayList<>();
        backtrack(S, n, 0, subconjuntoAtual, resultado);
        return resultado;
    }

    private static void backtrack(int[] S, int n, int inicio, List<Integer> subconjuntoAtual, List<List<Integer>> resultado) {
        if (subconjuntoAtual.size() == n) {
            resultado.add(new ArrayList<>(subconjuntoAtual));
            return;
        }

        for (int i = inicio; i < S.length; i++) {
            subconjuntoAtual.add(S[i]);
            backtrack(S, n, i + 1, subconjuntoAtual, resultado);
            subconjuntoAtual.remove(subconjuntoAtual.size() - 1);
        }
    }
}
