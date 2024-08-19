public class Main {
    public static void main(String[] args) {
        FilaCircular<Integer> fila = new FilaCircular<>(Integer.class, 5);

        fila.adicionar(1);
        fila.adicionar(2);
        fila.adicionar(3);

        System.out.println(fila.remover());
        System.out.println(fila.remover());

        fila.adicionar(4);
        fila.adicionar(5);
        fila.adicionar(6);

        System.out.println(fila.estaCheia());

        fila.limpar();

        System.out.println(fila.estaVazia());
    }
}
