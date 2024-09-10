package Main.com;

public interface MinMax<T extends Comparable<T>> {
	T findMin(T[] array);
    T findMax(T[] array);
}
