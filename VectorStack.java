import java.util.Vector;

public class VectorStack<T> implements Stack<T> {
    private Vector<T> stack;

    public VectorStack() {
        stack = new Vector<>();
    }

    
    /** 
     * @param item
     */
    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Error: Pila vacía.");
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Error: Pila vacía.");
        }
        return stack.lastElement();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
