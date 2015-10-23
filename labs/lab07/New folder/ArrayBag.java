import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Array-based implementation of the Bag interface.
 * @author Dean Hendrix
 * @author Xing Wang
 * @version 2015-10-15
 */

public class ArrayBag<T> implements Bag<T>, Iterable<T> {

	private static final int DEFAULT_CAPACITY = 1;

	private T[] arr;
	private int N;

	@SuppressWarnings("unchecked")
	public ArrayBag(int capacity) {
		arr = (T[]) new Object[capacity];
		N = 0;
	}

	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}

	public boolean add(T element) {
		if (N == arr.length)
			resize(arr.length * 2);
		arr[N++] = element;
		return true;
	}

	public boolean remove(T element) {
		int loc = locate(element);
		if (loc == -1)
			return false;
		arr[loc] = arr[--N];
		arr[N] = null;
		if (N > 0 && N < arr.length / 4)
			resize(arr.length / 2);
		return true;
	}

	public boolean removeWithShift(T element) {
		int loc = locate(element);
		if (loc < 0)
			return false;
		for (int i = loc + 1; i < N; i++) {
			arr[i - 1] = arr[i]; 
		}
		arr[N--] = null;
		if (N > 0  && N < arr.length / 4)
			resize(arr.length /  2);
		return true;
	}

	public boolean contains(T element) {
		return locate(element) >= 0;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}
		StringBuilder result = new StringBuilder();
		result.append("[");
		for (T item : this) {
			result.append(item + ", ");
		}
		result.delete(result.length() - 2, result.length());
		result.append("]");
		return result.toString();
	}

	private void resize(int capacity) {
		T[] arrCopy = Arrays.<T>copyOf(arr, capacity);
		arr = arrCopy;
	}

	private int locate(T target) {
		for (int i = 0; i < N; i++) {
			if (arr[i].equals(target))
				return i;
		}
		return -1;
	}

	private void shiftLeft(int loc) {
		for (int i = loc+1; i < N; i++)
			arr[i-1] = arr[i];
		arr[N - 1] = null;
	}

   public Iterator<T> iterator() {
      return new ArrayIterator<T>(arr, size());
   }

	private class ArrayIterator<T> implements Iterator<T> {
		public T[] items;
		public int count;
		public int current;

		public ArrayIterator(T[] arr, int N) {
			items = arr;
			count = N;
			current = 0;
		}

		public boolean hasNext() {
			return current < count;
		}

		public T next() {
			if (!hasNext()) 
				throw new NoSuchElementException();
			return items[current++];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}