
   public class LectureNotesExamples {
   
      public static void main(String[] args) {
      
         //addExample1();
         //selfCheckExercise();
         //removeExample1();
         //removeExample2();
         //removeExample3();
         removeExample4();
      }
      
   	
   	
      public static void addExample1() {
         int[] a = {30, 20, 50, 10, 40, 70, 60};
      
         AVLTree<Integer> t = new AVLTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
         
         t.add(15);
         System.out.println(t);
      }
   	
   	
      public static void selfCheckExercise() {
         int[] a = {10, 85, 15, 70, 20, 60, 30, 50, 65, 80, 90, 40, 5, 55};
      
         AVLTree<Integer> t = new AVLTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
      }
      
   	
      public static void removeExample1() {
         int[] a = {30, 20, 50, 10, 40, 70, 60};
      
         AVLTree<Integer> t = new AVLTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
         
         t.add(15);
         System.out.println(t);
         
         t.remove(40);
         System.out.println(t);
      }
      
   	
      public static void removeExample2() {
         int[] a = {10, 85, 15, 70, 20, 60, 30, 50, 65, 80, 90, 40, 5, 55};
      
         AVLTree<Integer> t = new AVLTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
         
         t.remove(60);
         System.out.println(t);
      }
      
   	
      public static void removeExample3() {
         int[] a = {10, 85, 15, 70, 20, 60, 30, 50, 65, 80, 90, 40, 5, 55};
      
         AVLTree<Integer> t = new AVLTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
         
         t.remove(60);
         System.out.println(t);
         
         t.remove(80);
         System.out.println(t);
      }
   	
   	
      public static void removeExample4() {
         int[] a = {13, 5, 16, 3, 8, 15, 19, 1, 4, 7, 11, 14, 17, 20, 2, 6, 10, 12, 18, 9};
      
         AVLTree<Integer> t = new AVLTree<Integer>();
         
         for (int i = 0; i < a.length; i++) {
            t.add(a[i]);
         }
         System.out.println(t);
         
         t.remove(20);
         System.out.println(t);
         
      }
   	
   	
   }