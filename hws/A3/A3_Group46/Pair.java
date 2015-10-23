public class Pair implements Comparable<Pair> {
   private int val1;
   private int val2;
   
   public Pair(int v1, int v2) {
      this.val1 = v1;
      this.val2 = v2;
   }

   public int compareTo(Pair other) {
      //return (this.val1).compareTo(other.val1);
      if (this.val1 < other.val1)
         return -1;
      else if (this.val1 > other.val1)
         return 1;
      else
         return 0;
   }
   
   public String toString() {
      return String.format("(" + val1 + ", " + val2 +")");
   }

}
