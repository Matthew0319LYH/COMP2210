/**
 * Lab3BGenerics.java
 * Used to illustrate basic principles of generic types
 * and type safety in Java.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2015-08-24
 *
 */
public class Lab3BGenerics {

    /**
     * Make this method generic and type safe. Use a
     * type variable named T that will allow you to
     * find the minimum element of an array of any
     * type of mutually-comparable values.
     */
   /*public static Comparable min(Comparable[] a) {
      Comparable min = a[0];
      for (Comparable val : a) {
         if (val.compareTo(min) < 0) {
            min = val;
         }
      }
      return min;
   } */
   
   public static <T extends Comparable<T>> T min(T[] a) {
      T min = a[0];
      for (T val : a) {
         if (val.compareTo(min) < 0)
            min = val;
      }
      return min;
   }

  /** Drives execution. */
   public static void main(String[] args) {
      Integer[] a2 = {4, 10, 2, 8, 6};
      String[] a3 = {"red", "orange", "yellow", "green", "blue", "indigo", "violet"};
   
       // You'll need to change some of these
       // statements once you make the min
       // method generic.
      //Comparable min1 = Lab3BGenerics.min(a2);
      Integer min1 = Lab3BGenerics.<Integer>min(a2);
      System.out.println(min1);
      //Comparable min2 = Lab3BGenerics.min(a3);
      String min2 = Lab3BGenerics.<String>min(a3);
      System.out.println(min2);
   }

}
