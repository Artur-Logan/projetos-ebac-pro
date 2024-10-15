package exercicios;

public class Exercicio2 {

    public static long fatorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }


    public static void main(String[] args) {
        int n = 3;

        System.out.println("Elemento " + n + ": " + fatorial(n));
    }
}
