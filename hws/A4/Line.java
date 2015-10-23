import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Line.java
 * Models a line segment as a Set of Points.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2015-09-23
 *
 */
public class Line implements Comparable<Line>, Iterable<Point> {
 
   SortedSet<Point> line;
   
   /** Creates a new line with no points. */
   public Line() {
      line = new TreeSet<Point>();
   }
   
   /** Creates a new line with all distinct collinear points in c. */
   public Line(Collection<Point> c) {
      line = new TreeSet<Point>();
      for (Point p : c) {
        line.add(p);
      }
      //addAll(c);
   }
 
   /** Adds p to this line if distinct and collinear with current points. */
   public boolean add(Point p) {
      if ((line.size() == 0) || (line.size() == 1)) {
        return line.add(p); // implement add() method in the superclass TreeSet
                            // returns false if p duplicate
      }
    /*if (line.size() == 1) {
      if (!(line.first()).equals(p)) {
        line.add(p);
      } */
      if (p.slopeTo(line.first()) == p.slopeTo(line.last()) ) 
        return line.add(p);
      
      return false;
   }
   
   /** Returns the first (minimum) point on this line. */
   public Point first() {
      if (line.size() == 0)
        return null;
      return line.first();
   }
   
   /** Returns the last (maximum) point on this line. */
   public Point last() {
      if (line.size() == 0)
        return null;
      return line.last();     
   }
   
   /** Returns the number of points on this line. */
   public int length() {
      //return Integer.MIN_VALUE;
      return line.size();
   }
    
  // compare this line to that line
   @Override
   public int compareTo(Line that) {
      //return Integer.MIN_VALUE;
      //if (this.equals(that))
      //  return 0;

      int cmp = this.first().compareTo(that.first());
      if (cmp == 0) {
        cmp = this.last().compareTo(that.last());
      }
      return cmp;
      /*if ((this.first()).compareTo(that.first()) == 0) 
        return (this.last()).compareTo(that.last());
      else
        return (this.first()).compareTo(that.first());*/
      
      /*if ((this.first()).compareTo(that.first()) < 0)
          return -1;
      if (this.first().compareTo(that.first()) == 0) {
        if (this.last().compareTo(that.last()) < 0)
          return -1;
        if (this.last().compareTo(that.last()) == 0)
          return 0;
      }
      return +1;*/
   }
   
  // provide an iterator over all the points on this line
   @Override
   public Iterator<Point> iterator() {
      //return null;
      return line.iterator();
   }
   
   /** 
    * Return true if this point's x and y coordinates are
    * the same as that point's x and y coordinates.
    * Return false otherwise.
    */
   @Override 
   public boolean equals(Object obj) {
   // DO NOT MODIFY
      if (obj == this) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (!(obj instanceof Line)) {
         return false;
      }
      Line that = (Line) obj;
      return (this.first().equals(that.first())) && (this.last().equals(that.last()));
   }
 
  // return this line as a String
   @Override
   // DO NOT MODIFY
   public String toString() {
      StringBuilder s = new StringBuilder();
      for (Point p : line) {
         s.append(p + " -> ");
      }
      s = s.delete(s.length() - 4, s.length());
      return s.toString();
   }
 
}