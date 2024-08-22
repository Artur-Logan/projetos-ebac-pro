public class Fifo {

    public static void main(String[] args) {

        Fifo fifo = new Fifo(7);

        fifo.enqueue(1);
        fifo.enqueue(2);
        fifo.enqueue(3);
        fifo.enqueue(4);
        fifo.enqueue(5);
        fifo.enqueue(6);
        fifo.enqueue(7);

        System.out.println("Verificação se a fila está vazia: " + fifo.isEmpty());
        System.out.println("Verificação se a fila está cheia: " + fifo.isFull());
        System.out.println("Primeiro elemento da fila : " + fifo.front());
        System.out.println("Tamanho: " + fifo.size());

        fifo.dequeue();

        System.out.println("Tamanho após o dequeue: " + fifo.size());
        System.out.println("Ultimo elemento da lista: " + fifo.rear());

        fifo.dequeue();
        System.out.println("Ultimo elemento da lista: " + fifo.rear());

    }

    private Integer[] elementos;
    private int capacidade;
    private int inicio;
    private int fim;
    private int tamanho;

    public Fifo(int capacidade){
        this.capacidade = capacidade;
        elementos= new Integer[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public void enqueue(Integer elemento){
        if (isFull()){
            throw new IllegalArgumentException("A fila está cheia");
        }

        fim = (fim + 1) % capacidade;
        elementos[fim] = elemento;
        tamanho++;
    }

    public Integer dequeue(){
        if (isEmpty()){
            throw new IllegalArgumentException("A fila está vazia");
        }

        int elementoRemovido = elementos[inicio];
        elementos[inicio] = 0;
        inicio = (inicio + 1) % capacidade;
        tamanho--;

        return elementoRemovido;
    }

    public Integer front(){
        if (isEmpty()){
            throw new IllegalArgumentException("A fila está vazia");
        }

        return elementos[inicio];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public int  size(){
        if (this.isEmpty()){
            return 0;
        }
        return this.tamanho;
    }

    public int rear(){
        if (this.isEmpty()){
            throw new IllegalArgumentException("Lista vazia");
        }

        return elementos[tamanho];
    }
}
