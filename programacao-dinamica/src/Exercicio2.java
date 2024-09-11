public class Exercicio2 {

    public static int fatorialBottomUp(int n){
        int[] tabela = new int[n + 1];

        tabela[0] = 1;
        tabela[1] = 1;

        for (int i = 2; i <= n; i++){
            tabela[i] = i * tabela[i - 1];
        }
        return tabela[n];
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println("Fatorial de " + n + ": " + fatorialBottomUp(n));

        int m = 100;

        System.out.println("Elemento " + n + ": " + encontrarElementoPb(m));
    }

    private static int MAX_ELEMENTS = 150;
    private static final long[] elemnetosFib = new long[MAX_ELEMENTS];

    public static long encontrarElementoPb(int n){
        for (int i = 0; i < MAX_ELEMENTS; i++){
            elemnetosFib[i] = -1;
        }

        return encontrarElemento(n);
    }

    public static long encontrarElemento(int n){
        if (elemnetosFib[n] == -1){
            if (n <= 1){
                elemnetosFib[n] = n;
            } else {
                elemnetosFib[n] = encontrarElemento(n - 1) + encontrarElemento(n - 2);
            }
        }

        return elemnetosFib[n];
    }
}

