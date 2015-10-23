import java.util.Iterator;
/**
 * StackInterface.java. Describes abstract behavior of
 * a LIFO stack.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2013-02-25
 *
 */
public interface StackInterface<T> extends Iterable<T> {
  
   /**
    * Adds one element to the top of this stack.
    */
   void push(T element);
   
   /**
    * Removes and returns the top element from this stack.
    */
   T pop();
   
   /**
    * Returns without removing the top element of this stack.
    */
   T peek();
  
   /**
    * Returns true if this stack contains no elements.
    */
   boolean isEmpty();
   
   /**
    * Returns the number of elements in this stack.
    */
   int size();
    
   /**
    * Returns an Iterator for this stack.
    */
   Iterator<T> iterator();
  
}