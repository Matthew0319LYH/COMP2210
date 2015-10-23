
/**
 * Illustrative client for ArrayStack.java.
 */
public class ArrayStackClient {
 
   public static void main(String[] args) {
      ArrayStack<String> s = new ArrayStack<>();
      s.push("A");
      s.push("B");
      s.push("C");
      s.push("D");
      s.push("E");
   
      System.out.println(s.size());
   
      s.pop();
      s.pop();
      s.pop();
      s.pop();
      s.pop();
   
      System.out.println(s.size());
      
      for (int i = 0; i < s.CAPACITY; i++) {
         s.push("X");
      }
      
      System.out.println(s.size());
      
      s.push("X");
   
   }
 
}