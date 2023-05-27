import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorRevertido<T> implements Iterator<T> {
    private Celula current;

    public IteratorRevertido(Celula last) {
        this.current = last;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Não tem mais elementos na lista.");
        }

        T element = (T) current.getElemento();
        current = current.getAnterior();
        return element;
    }
}
