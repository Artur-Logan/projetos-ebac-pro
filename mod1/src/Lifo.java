//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Lifo {

    public static void main(String[] args) {

        Lifo lifo = new Lifo();

        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        lifo.push(4);
        lifo.push(5);

        System.out.println(lifo.top());
        System.out.println();

        System.out.println("Itens na pilha: " + lifo.size());

        while (lifo.isEmptyList() == false){
            System.out.println(lifo.pop());
        }

        System.out.println("Itens na pilha após o método pop: " + lifo.size());
    }

    private Object[] itens;
    private int posicaoHandle;

    public Lifo(){
        itens = new Object[10];
        posicaoHandle = -1;
    }

    public void push(Integer numero){
        if (this.posicaoHandle < this.itens.length - 1){
//            this.posicaoHandle = this.posicaoHandle + 1;
//            this.itens[this.posicaoHandle] = numero;

            this.itens[++this.posicaoHandle] = numero;
        }
    }

    public Object pop(){
        if (isEmptyList()){
            return null;
        }
//
//        Object value = itens[this.posicaoHandle];
//        this.posicaoHandle = this.posicaoHandle - 1;

        Object value = itens[this.posicaoHandle--];

        return value;
    }

    public boolean isEmptyList(){
        if (this.posicaoHandle == -1){
            return true;
        }

        return false;
    }

    public Object top(){
        if (isEmptyList()){
            return null;
        }
        return this.itens[posicaoHandle];
    }

    public int size() {
        if (this.isEmptyList()) {
            return 0; // aqui indica que não tem nenhum conteúdo dentro da pilha
        }
        return this.posicaoHandle + 1;
        // aqui indica quantos itens tem dentro da pilha, somando-se 1,
        //pois a pilha inicia no zero. Logo, se tivermos 3 itens na pilha,
        // o atributo posicaoPilha vai exibir 2.
        //Para sabermos quantos itens há, precisamos somar um.
    }
}