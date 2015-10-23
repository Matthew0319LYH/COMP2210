import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;

public final class GenericsSelector {

	private GenericsSelector() {}

	public static <T> T min(Collection<T> c, Comparator<T> comp) {
		if (c == null || comp == null) 
			throw new IllegalArgumentException();
		if (c.isEmpty())
			throw new NoSuchElementException();
		Iterator<T> iter = c.iterator();
		T minimum = iter.next();
		while (iter.hasNext()) {
			T element = iter.next();
			if (comp.compare(element, minimum) < 0) {
				minimum = element;
			}
		}
		return minimum;
	}

	public static <T> T max(Collection<T> c, Comparator<T> comp) {
		if (c == null || comp == null) 
			throw new IllegalArgumentException();
		if (c.size() == 0)
			throw new NoSuchElementException();
		Iterator<T> iter = c.iterator();
		T maximum = iter.next();
		while (iter.hasNext()) {
			T element = iter.next();
			if (comp.compare(element, maximum) > 0)
				maximum = element;
		}
		return maximum;
	}

	public static <T> T kmin(Collection<T> c, int k, Comparator<T> comp) {
		if (c == null || comp == null)
			throw new IllegalArgumentException();
		if (c.size() == 0 || k < 1 || k > c.size())
			throw new NoSuchElementException();
		List<T> list = new ArrayList<>();
		for (T element : c) {
			list.add(element);
		}

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (comp.compare(list.get(i), list.get(j)) == 0)
					list.remove(j);
			}
		}

		if (k > list.size())
			throw new NoSuchElementException();
		Collections.sort(list, comp);
		return list.get(k - 1);
	}

	public static <T> T kmax(Collection<T> c, int k, Comparator<T> comp) {
		if (c == null || comp == null)
			throw new IllegalArgumentException();
		if (c.size() == 0 || k < 1 || k > c.size())
			throw new NoSuchElementException();
		Set<T> tempSet = new TreeSet<>();
		tempSet.addAll(c);
		List<T> list = new ArrayList<>(tempSet);
		Collections.sort(list, comp);
		if (k > list.size())
			throw new NoSuchElementException();
		return list.get(list.size() - k);
	}

	public static <T> Collection<T> range(Collection<T> c, T low, T high, Comparator<T> comp) {
		if (c == null || comp == null)
			throw new IllegalArgumentException();
		if (c.isEmpty())
			throw new NoSuchElementException();
		Collection<T> b = new ArrayList<>();
		for (T element : c) {
			if ((comp.compare(low, element) < 0) && (comp.compare(element, high) > 0))
				b.add(element);
		}
		if (b.size() == 0)
			throw new NoSuchElementException();
		return b;
	}

	public static <T> T ceiling(Collection<T> c, T key, Comparator<T> comp) {
		if (c == null || comp == null)
			throw new IllegalArgumentException();
		if (c.isEmpty())
			throw new NoSuchElementException();
		T ceil = null;
		//boolean assigned = false;
		Iterator<T> iter = c.iterator();
      T element;
		//T element = iter.next();
      //ceil = element;
		//if (comp.compare(element, key) >= 0)
		//	ceil = element;
		//	assigned = true;
		while (iter.hasNext()) {
			element = iter.next();
			if (comp.compare(element, key) >= 0) { 
				if (ceil == null) {
					ceil = element;
				}
				else {
					if (comp.compare(element, ceil) < 0)
						ceil = element;
				}
			}
		}
		if (ceil == null)
			throw new NoSuchElementException();
		return ceil;
	}

	public static <T> T floor(Collection<T> c, T key, Comparator<T> comp) {
		if (c == null || comp == null)
			throw new IllegalArgumentException();
		if (c.size() == 0)
			throw new NoSuchElementException();
		T flr = null;
		//boolean assigned = false;
		Iterator<T> iter = c.iterator();
      T element;
		//T element = iter.next();
		//if (comp.compare(element, key) <= 0) {
		//	flr = element;
		//	assigned = true;
		//}
		while (iter.hasNext()) {
			element = iter.next();
			if (comp.compare(element, key) <= 0) {
				if (flr == null) {
					flr = element;
				}
				else {
					if (comp.compare(element, flr) > 0)
						flr = element;
				}
			}
		}
		if (flr == null)
			throw new NoSuchElementException();
		return flr;
	}

}