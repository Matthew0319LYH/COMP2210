/**
 * TimingCode.java
 * Illustrates basic approach to measuring a method's
 * running time.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
<<<<<<< HEAD
 * @version  2015-09-01
=======
 * @version  2015-02-09
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
 *
 */
public class TimingCode {

<<<<<<< HEAD
   private static final double SECONDS = 1_000_000_000d;
   private static final int NUM_RUNS = 10;

  /** Drives execution. */
   public static void main(String[] args) {
      long start;
      long elapsedTime;
      double avgTime = 0d;
=======
   public static void main(String[] args) {
      long start, elapsedTime;
      double avgTime = 0d;
      int NUM_RUNS = 10;
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
      for (int i = 0; i < NUM_RUNS; i++) {
         start = System.nanoTime();
         foo();
         elapsedTime = System.nanoTime() - start;
<<<<<<< HEAD
         avgTime = avgTime +  elapsedTime;
      }
      avgTime = avgTime / NUM_RUNS;
      avgTime = avgTime / SECONDS;
=======
         avgTime += elapsedTime;
      }
      avgTime = avgTime / NUM_RUNS;
      avgTime = avgTime / 1_000_000_000d; // convert to seconds
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
      System.out.printf("%s%4.3f%s\n", "Method foo's running time: ", avgTime, " seconds");
   }


<<<<<<< HEAD
   /** Something that will hopefully take time >= 0.001 seconds. */
=======
   // Something that will hopefully take time >= 0.001 seconds
   // so that the program output looks better.
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
   private static void foo() {
      for (int i = 0; i < 100_000; i++) {
         String s1 = "War";
         String s2 = "Eagle";
         String s3 = s1 + s2;
         s1 = null;
         s2 = null;
         s3 = null;
      }
   }

}
