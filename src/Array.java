public class Array<E> {
    private E[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    public Array(int initialCapacity) {
        stack = (E[]) new Object[initialCapacity];
        top = -1;
    }

    public void push(E element) {
        if (top == stack.length - 1) {
            resize(stack.length * 2);
        }
        stack[++top] = element;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newStack = (E[]) new Object[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, top + 1);
        stack = newStack;
    }
}
