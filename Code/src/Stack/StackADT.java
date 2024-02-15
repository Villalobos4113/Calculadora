package Stack;

public interface StackADT <T> {

    public void push(T dato);
    public T pop();
    public boolean isEmpty();
    public T peek();
    public void multiPop(int n);

}
