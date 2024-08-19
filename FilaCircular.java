import java.lang.reflect.Array;

public class FilaCircular<T> {
    private int topo = -1;
    private int base = 0;
    private T[] dados;

    public FilaCircular(Class<T> clazz, int tamanho) {
        dados = (T[]) Array.newInstance(clazz, tamanho);
    }

    public void adicionar(T item) {
        if (estaCheia()) {
            throw new IllegalStateException("Fila está cheia");
        }
        topo = (topo + 1) % dados.length;
        dados[topo] = item;
    }

    public T remover() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila está vazia");
        }
        T item = dados[base];
        dados[base] = null;
        base = (base + 1) % dados.length;
        if (base == (topo + 1) % dados.length) {
            topo = -1;
            base = 0;
        }
        return item;
    }

    public boolean estaCheia() {
        return (topo + 1) % dados.length == base && dados[base] != null;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public void limpar() {
        topo = -1;
        base = 0;
        for (int i = 0; i < dados.length; i++) {
            dados[i] = null;
        }
    }
}
