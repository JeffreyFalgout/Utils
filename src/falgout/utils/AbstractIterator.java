package falgout.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<E> implements Iterator<E> {
    protected boolean init = false;
    protected E last;
    protected E next;
    
    public AbstractIterator() {}
    
    protected boolean init() {
        if (!init) {
            next = findNext();
            init = true;
            return true;
        }
        
        return false;
    }
    
    protected abstract E findNext();
    
    @Override
    public boolean hasNext() {
        init();
        return next != null;
    }
    
    @Override
    public E next() {
        if (next == null) {
            init();
            if (next == null) { throw new NoSuchElementException(); }
        }
        last = next;
        next = findNext();
        return last;
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
