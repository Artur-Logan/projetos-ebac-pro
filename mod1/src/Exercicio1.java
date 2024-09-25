//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Exercicio1 {

    public static long fatorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }


    public static void main(String[] args) {
        int n = 70;

        System.out.println("Elemento " + n + ": " + fatorial(n));
    }
}