/**
 * Sample client for a singly linked node, implememted
 * as an inner class.
 */
public class ClientWithSinglyLinkedInnerClass {
 
/**
 * Defines a singly-linked node.
 */
   private class Node {
      private Object element;
      private Node next;
      
      public Node(Object e) {
         element = e;
      }
      
      public Node(Object e, Node n) {
         element = e;
         next = n;
      }
   }
   
  /**
   * Call a method to perform example operations on nodes.
   */ 
   public static void main(String[] args) {
   
      ClientWithSinglyLinkedInnerClass client = new ClientWithSinglyLinkedInnerClass();
      client.basicExamples();
   }
   
  /**
   * Creates the examples from lecture notes.
   */ 
   public void basicExamples() {
   
   // Declaration;
      Node n;
      
   // Constructors, garbage
      n = new Node(1);
      n = new Node(2, n);
      n = new Node(3);
      n = null;
   
   // basic linking
      n = new Node(1);
      n = new Node(2, n);
      n.next = new Node(3, n.next);
   
      n = new Node(1, new Node(2));
      n.next.next = new Node(3, null);
      n = new Node(4, n.next);
      
   // participation question
      n = new Node(1);
      n.next = new Node(2, new Node(3));
      n = new Node(4, n.next.next);
   
   // calling length and contains
      n = new Node(1, new Node(2, new Node(3, new Node(4))));
      int len = length(n);
      String s = asString(n);
      System.out.println ("n -> " + s);
      System.out.println("length = " + len);
      System.out.println(contains(n, 3));
      System.out.println(contains(n, 0));
   }
   
  /**
   * Returns a string representation of the pointer chain accessible
   * from n.
   */ 
   public String asString(Node n) {
      if (n == null)
         return "NULL";
   
      StringBuffer s = new StringBuffer();
      Node p = n;
      while (p != null) {
         s.append(p.element);
         s.append(" -> ");
         p = p.next;
      }
      s.delete(s.length()-3, s.length());
      return s.toString();
   }
	
  /**
   * Returns the number of nodes accessible from n.
   */ 
   public int length(Node n) {
      Node p = n;
      int len = 0;
      while (p != null) {
         len++;
         p = p.next;
      }
      return len;
   }
   
  /**
   * Searches for target in the pointer chain accessible from n.
   */ 
   public boolean contains(Node n, Object target) {
      Node p = n;
      while (p != null) {
         if (p.element.equals(target)) {
            return true;
         }
         p = p.next;
      }
      return false;
   }
	
  /**
   * Sets up an example to add a new node into an 
   * existing pointer chain.
   */ 
   public void add() {
      Node n = new Node("A");
      n.next = new Node("B");
      n.next.next = new Node("C");
      n.next.next.next = new Node("D");
   
      Node p = null; // to find the right spot
      Node temp = new Node("X"); // to create new node
   
      System.out.println();
   }
 
}