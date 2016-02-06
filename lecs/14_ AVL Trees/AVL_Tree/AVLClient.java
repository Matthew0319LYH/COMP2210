
   public class AVLClient {
   
      public static void main(String[] args) {
      
         int[] a = {10, 85, 15, 70, 20, 60, 30, 50, 65, 80, 90, 40, 5, 55};
      
         AVLTree<Integer> t = new AVLTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
      
         for (int i = 0; i < a.length; i++) {
            t.remove(a[i]);
         }
         System.out.println(t);
      
      }
   
   }