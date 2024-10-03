package exercicios;

public class Exercicio2 {

    public static void main(String[] args) {
        int[] moedas = {10, 5, 2};

        int quantia = 18;

        int numeroMinimoDeMoedas = calcularTroco(quantia, moedas);
        System.out.println(numeroMinimoDeMoedas);
    }

    public static int calcularTroco(int quantia, int[] moedas){
        int numeroDeMoedas = 0;

        for (int moeda : moedas){
            while (quantia >= moeda){
                quantia -= moeda;
                numeroDeMoedas++;
            }
        }

        if (quantia > 0){
            return -1;
        }

        return numeroDeMoedas;
    }
}
