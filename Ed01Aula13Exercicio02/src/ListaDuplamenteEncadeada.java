import java.util.Iterator;
public class ListaDuplamenteEncadeada extends ListaDupla implements Iterable<Object> {
   
    @Override
    public Iterator<Object> iterator() {
        return new ListaIterator();
    }
    private class ListaIterator implements Iterator<Object> {
        private Celula atual = Primeira;
        @Override
        
        public boolean hasNext() {
            return atual != null;
        }

        @Override
        public Object next() {
            Object elemento = atual.getElemento();
            atual = atual.getProxima();
            return elemento;
        }
    }
    public Iterator<Object> iteratorRevertido() {
        return new IteratorRevertido<>(Ultima);
    }
}   