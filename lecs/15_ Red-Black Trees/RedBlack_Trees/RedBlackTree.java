
   public class RedBlackTree<T extends Comparable<? super T>> {
   
      private static final boolean RED = true;
      private static final boolean BLACK = false;
   
      private Node root;
      private int size;
   
      public RedBlackTree() {
         root = null;
         size = 0;
      }
   
      public void add(T element) {
         root = put(root, element, false);
         root.color = BLACK;
         size++;
      }
      
   	
      public boolean contains(T element) {
         return search(root, element);
      }
   
   
      public int height() {
         return height(root);
      }
   
      
      public int size() {
         return this.size;
      }
      
   	
      @Override
      public String toString() {
         return inorderString(root);
      }
      
   	
   	
   	
   	
   	
   
      private class Node {
         T element;
         Node left, right;
         boolean color;
         
         public Node(T element, boolean color) {
            this.element = element;
            this.color = color;
         }
      } 
   	
   	/** From Sedgewick 3E pg. 580 */
   	/** sw => "same way" orientation. Differentiates straight lines from zig-zags  */
      private Node put(Node n, T element, boolean sw) {
      
         if (n == null) {
            return new Node(element, RED);
         }
         
      	// split 4-nodes on the way down.
         if (isRed(n.left) && isRed(n.right)) {
            n.color = RED;
            n.left.color = BLACK;
            n.right.color = BLACK;
         }
         
         int cmp = element.compareTo(n.element);
         if (cmp < 0) {
            n.left = put(n.left, element, false);
            // rotate and recolor on the way back up
            if (isRed(n) && isRed(n.left) && sw)
               n = rotateRight(n);
            if (isRed(n.left) && isRed(n.left.left)) {
               n = rotateRight(n);
               n.color = BLACK;
               n.right.color = RED;
            }
         }
         else if (cmp > 0) {
            n.right = put(n.right, element, true);
            // rotate and recolor on the way back up
            if (isRed(n) && isRed(n.right) && !sw)
               n = rotateLeft(n);
            if (isRed(n.right) && isRed(n.right.right)) {
               n = rotateLeft(n);
               n.color = BLACK;
               n.left.color = RED;
            }
         }
      		
         return n;
      }
      
   	
      private boolean search(Node n, T element) {
      
         if (n == null)
            return false;
         else {
            int cmp = element.compareTo(n.element);
            if (cmp < 0)        
               return search(n.left, element);
            else if (cmp > 0)   
               return search(n.right, element);
            else                
               return true;
         }
      }
      
   	
      private String inorderString(Node n) {
         if (n == null)
            return "";
         else
            return inorderString(n.left) + " " + n.element + " " + inorderString(n.right);
      }
   
   
      private int height(Node n) {
         if (n == null)
            return 0;
         else
            return 1 + Math.max(height(n.left), height(n.right));
      }
   
   
   		
      private boolean isRed(Node n) {
         if (n == null) 
            return false;
         else           
            return n.color == RED;
      }
   	
      private Node rotateLeft(Node n) {
         Node m = n.right;
         n.right = m.left;
         m.left = n;
         m.color = n.color;
         n.color = RED;
         return m;
      }
   	
      private Node rotateRight(Node n) {
         Node m = n.left;
         n.left = m.right;
         m.right = n;
         m.color = n.color;
         n.color = RED;
         return m;
      }
      
      private void flipColors(Node n) {
         n.color = RED;
         n.left.color = BLACK;
         n.right.color = BLACK;
      }
      
   	
      private String inorderString(Node n, String result) {
         if (n != null) {
            inorderString(n.left, result);
            result += n.element;
            System.out.println(n.element);
            inorderString(n.right, result);
         }
         return result;
      }
   	
   }