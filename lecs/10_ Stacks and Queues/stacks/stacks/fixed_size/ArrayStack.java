import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * StackInterface.java. Provides a fixed sized
 * array-based implementation of StackInterface.
 *
 * All stack methods, including iterator creation, are
 * supported in worst-case O(1) time.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2013-02-25
 *
 */
public class ArrayStack<T> implements StackInterface<T> {

   public static final int CAPACITY = 10;  // fixed capacity

   private T[] stack;  // array to store elements of stack
   private int top;    // location of first empty position

  /**
   * Constructs an empty stack.
   */
   @SuppressWarnings("unchecked")
   public ArrayStack() {
      stack = (T[]) new Object[CAPACITY];
      top = 0;
   }
  
   /**
    * Adds one element to the top of this stack.
    */
   public void push(T element) {
      if (element == null)
         throw new IllegalArgumentException("Null values not allowed in stack.");
   
      if (size() == CAPACITY) {
         throw new OutOfMemoryError("Stack capacity of " + CAPACITY + " exceeded.");
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