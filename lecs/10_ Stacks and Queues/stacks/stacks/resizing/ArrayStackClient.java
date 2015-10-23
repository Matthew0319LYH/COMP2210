
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
   
      System.out.print(s.size() + " ");
      for (String str : s) {
         System.out.print(str + " ");
      }
      System.out.println();
   
      s.pop();
      s.pop();
      s.pop();
      s.pop();
   
      System.out.print(s.size() + " ");
      for (String str : s) {
         System.out.print(str + " ");
      }
      System.out.println();
      
      s.pop();
   
   }
 
}