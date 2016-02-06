
   public class LectureNotesExamples {
   
      public static void main(String[] args) {
      
         //treeExample1();
         //addExample1();
         //addCase1();
         //addCase2_3();
         addCase4_5();
         //selfCheckExercise();
      }
      
   	
   	
      public static void treeExample1() {
         int[] a = {7, 4, 14, 3, 5, 12, 15, 18};
      
         RedBlackTree<Integer> t = new RedBlackTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
         
      }
   	
   	
      public static void addExample1() {
         int[] a = {7, 4, 14, 3, 5, 12, 15, 18};
      
         RedBlackTree<Integer> t = new RedBlackTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
         
         t.add(2);
         System.out.println(t);
      }
      
   	
      public static void addCase1() {
         int[] a = {7, 4, 14, 3, 5, 12, 15, 18};
      
         RedBlackTree<Integer> t = new RedBlackTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
         
         t.add(6);
         System.out.println(t);
      }
      
   	
      public static void addCase2_3() {
         int[] a = {20, 10, 30, 5, 25, 35};
      
         RedBlackTree<Integer> t = new RedBlackTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
         
         t.add(7);
         System.out.println(t);
      }
   
   
      public static void addCase4_5() {
         int[] a = {20, 10, 30, 15, 25, 35};
      
         RedBlackTree<Integer> t = new RedBlackTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
         
         t.add(12);
         System.out.println(t);
      }
   
   	
      public static void selfCheckExercise() {
         int[] a = {10, 85, 15, 70, 20, 60, 30, 50, 65, 80, 90, 40, 5, 55};
      
         RedBlackTree<Integer> t = new RedBlackTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
      }
      
   	
   
   	
   	
   }