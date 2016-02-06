public class FrequencyCounter {
	
	public static void main(String[] args) {
		int minlen = Integer.parseInt(args[0]);
		ST<String, Integer> st = new ST<>();
		while (!StdIn.isEmpty()) {
			String word = StdIn.readString();
			if (word.length() < minlen) continue;
			if (!st.contains(word))
				st.put(word, 1);
			else
				st.put(word, st.get(word) + 1);
		}
		String max = "";
		st.put(max, 0);
		for (String word : st.keys()) {
			if (st.get(word) > st.get(max))
				max = word;
		}
		
		StdOut.println(max + " " + st.get(max));
	}
}


public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	public int size() {
		return N;
	}
	
	public Value get(Key key) {
		if (isEmpty())
			return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else
			return null;
	}
	
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) /  2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}
	
	public void put(Key key, Value val) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
}


public class SequentialSearchST<Key, Value> {
	private Node first;
	
	private class Node {
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public Value get(Key key) {
		for (Node n = first; n != null; n = n.next) {
			if (key.equals(n.key))
				return n.val;
		}
		return null;
	}
	
	public void put(Key key, Value val) {
		for (Node n = first; n != null; n = n.next) {
			if (key.equals(n.key)) {
				n.val = val;
				return;
			}
		}
		first = new Node(key, val, first);
	}
}
