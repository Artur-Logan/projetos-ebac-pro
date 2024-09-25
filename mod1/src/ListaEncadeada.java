public class ListaEncadeada<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;

    private final int NAO_ENCONTRADO = -1;

    public void insert(T elemento){
        No<T> celula = new No<T>(elemento);
        if (this.tamanho ==  0){
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    public int size(){
        return this.tamanho;
    }

    @Override
    public String toString() {

        if (this.tamanho == 0){
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();

        No<T> atual = this.inicio;

        for (int i = 0; i < this.tamanho - 1; i++){
            stringBuilder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }
        stringBuilder.append(atual.getElemento());
//        stringBuilder.append(atual.getElemento()).append(", ");
//        while(atual.getProximo() != null){
//            atual = atual.getProximo();
//            stringBuilder.append(atual.getElemento()).append(", ");
//        }
           return stringBuilder.toString();
    }

    public void limpa() {
        for (No<T> atual = this.inicio; atual != null;) {
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    private No<T> buscaNo(int posicao){

        if (!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException("Posição não existe!");
        }

        No<T> noAtual = this.inicio;
        for (int i = 0; i < posicao; i++){
            noAtual = noAtual.getProximo();
        }

        return noAtual;
    }

    private Boolean posicaoNaoExiste(int posicao){
        return !(posicao >= 0 && posicao <= this.tamanho);
    }

    public T removeInicio(){
        if (this.tamanho == 0){
            throw new RuntimeException("A lista esta vazia");
        }

        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if (this.tamanho == 0){
            this.ultimo = null;
        }

        return removido;
    }

    public T removeFinal() {
        if (this.tamanho == 0) {
            throw new RuntimeException("LISTA_VAZIA");
        }
        if (this.tamanho == 1) {
            return this.removeInicio();
        }
        No<T> penultimoNo = this.buscaNo(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;

        return removido;
    }

    public T remove(int posicao){
        if (this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }

        if (posicao == 0){
            return this.removeInicio();
        }
        if (posicao == this.tamanho - 1){
            this.removeFinal();
        }

        No<T> noAnterior = this.buscaNo(posicao - 1);
        No<T> atual = noAnterior.getProximo();
        No<T> proximo = atual.getProximo();
        noAnterior.setProximo(proximo);
        atual.setProximo(null);
        this.tamanho--;

        return atual.getElemento();
    }

    public T buscaPorPosicao(int index){
        return this.buscaNo(index).getElemento();
    }

    public int busca(T elemento){

        No<T> noAtual = this.inicio;
        int pos = 0;

        while (noAtual != null){
            if (noAtual.getElemento().equals(elemento)){
                return pos;
            }
            pos++;
            noAtual = noAtual.getProximo();
        }

        return NAO_ENCONTRADO;
    }

    public static void main(String[] args) {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        listaEncadeada.insert(1);
        listaEncadeada.insert(2);
        listaEncadeada.insert(3);

        System.out.println(listaEncadeada);
        System.out.println("Tamanho da lista: " + listaEncadeada.size());

//        listaEncadeada.limpa();

        System.out.println("**************** BUSCA POR ELEMENTO");
        System.out.println("Tamanho da lista: " + listaEncadeada.size());
        System.out.println(listaEncadeada.busca(1));
        System.out.println(listaEncadeada.busca(2));
        System.out.println(listaEncadeada.busca(3));

        System.out.println("**************** BUSCA POR POSIÇAÕ");
        System.out.println(listaEncadeada.buscaPorPosicao(0));
        System.out.println(listaEncadeada.buscaPorPosicao(1));
        System.out.println(listaEncadeada.buscaPorPosicao(2));

        System.out.println(listaEncadeada);

        listaEncadeada.remove(1);

        System.out.println(listaEncadeada);
    }
}
