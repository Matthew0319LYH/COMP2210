import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * StackInterface.java. Provides a dynamically sized
 * array-based implementation of StackInterface.
 *
 * All stack methods, including iterator creation, are
 * supported in worst-case O(1) time (amortized for push
 * and pop.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2013-02-25
 *
 */
public class ArrayStack<T> implements StackInterface<T> {

   private T[] stack;  // array to store elements of stack
   private int top;    // location of first empty position

  /**
   * Constructs an empty stack of capacity 1.
   */
   @SuppressWarnings("unchecked")
   public ArrayStack() {
      stack = (T[]) new Object[1];
      top = 0;
   }
  
   /**
    * Adds one element to the top of this stack.
    */
   public void push(T element) {
      if (element == null)
         throw new IllegalArgumentException("Null values not allowed in stack.");
   
      if (size() == stack.length) {
         resize(stack.length * 2);
      }
      
      stack[top] = element;
      top++;
   }
   
   /**
    * Removes and returns the top element from this stack.
    */
   public T pop() {
      if (isEmpty())
         return null;
   
      top--;
      T result = stack[top];
      stack[top] = null;
      
      if (size() < (stack.length / 4))
         resize(stack.length / 2);
      
      return result;
   }
   
   /**
    * Returns without removing the top element of this stack.
    */
   public T peek() {
      if (isEmpty())
         return null;
      
      return stack[top];
   }
  
   /**
    * Returns true if this stack contains no elements.
    */
   public boolean isEmpty() {
      return size() == 0;
   }
   
   /**
    * Returns the number of elements in this stack.
    */
   public int size() {
      return top;
   }
    
   /**
    * Returns an Iterator for this stack.
    */
   public Iterator<T> iterator() {
      return new ArrayStackIterator();
   }
   
   /**
    * Resize the backing array.
    */
   @SuppressWarnings("unchecked")
   private void resize(int capacity) {
      T[] a = (T[]) new Object[capacity];
      for (int i = 0; i < size(); i++) {
         a[i] = stack[i];
      }
      clear(stack);
      stack = a;
   }
   
   /**
    * Set all the elements of the array to null.
    */
   private void clear(T[] a) {
      for (int i = 0; i < a.length; i++) {
         a[i] = null;
      }
   }   
   
   
   
   
   /**
    * Provide iteration behavior.
    */
   private class ArrayStackIterator implements Iterator<T> {
    
      private int current = top;
    
      public boolean hasNext() {
         return current > 0;
      }
    
      public T next() {
         if (!hasNext())
            throw new NoSuchElementException();
            
         current--;
         return stack[current];
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
    
   }
  
}