package exemplos;

public class Exemplo1 {

    public static void main(String[] args) {
        int [][] tab = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int n = 4;

        boolean resultado = resolveNRainhas(tab, n, 0); // Modificado para começar na linha 0

        if (resultado) {
            imprimirTab(tab);
        } else {
            System.out.println("Sem solução");
        }

    }

    // Modificado para garantir que estamos colocando uma rainha por linha
    private static boolean resolveNRainhas(int [][] tab, int n, int linhaAtual){
        if (n == 0){  // Se todas as rainhas foram colocadas
            return true;
        }

        // Tentamos colocar uma rainha na linha atual
        for (int j = 0; j < tab.length; j++){
            if (!temAtaque(linhaAtual, j, tab)){  // Se não há ataque, podemos colocar a rainha
                tab[linhaAtual][j] = 1;  // Coloca a rainha

                if (resolveNRainhas(tab, n - 1, linhaAtual + 1)){  // Move para a próxima linha
                    return true;
                }

                // Se colocar a rainha aqui não resulta em uma solução válida, removemos a rainha
                tab[linhaAtual][j] = 0;
            }
        }

        return false;  // Se nenhuma posição foi encontrada, voltamos (backtracking)
    }

    private static boolean temAtaque(int x, int y, int [][] tab){
        // Verifica se há uma rainha na mesma coluna
        for (int i = 0; i < x; i++){
            if(tab[i][y] == 1){
                return true;
            }
        }

        // Verifica diagonais
        for (int i = 0; i < x; i++) {
            int diagonalEsquerda = y - (x - i); // Diagonal à esquerda
            int diagonalDireita = y + (x - i); // Diagonal à direita

            if (diagonalEsquerda >= 0 && tab[i][diagonalEsquerda] == 1){
                return true;
            }

            if (diagonalDireita < tab.length && tab[i][diagonalDireita] == 1){
                return true;
            }
        }

        return false;
    }

    private static void imprimirTab(int [][] tab){
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                System.out.print(tab[i][j]);
            }
            System.out.println();
        }
    }
}
