package main.com;

public interface StackInterface<T> {
	void push(T element);
    T pop();
    T peek(); 
    boolean isEmpty(); 
}
