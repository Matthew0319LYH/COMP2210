	
/**
 * Models a position (x,y) in a 2-dimensional grid. The horizontal
 * dimension is indicated by x and the vertical dimension is
 * indicated by y. The origin is defined to be (0,0), and the
 * default constructor creates the origin position.
 *
 * A given position can reference the six possible grid positions
 * that surround it as defined by the following "directions"
 * 	north = (x,y+1)
 * 	northeast = (x+1,y+1)
 * 	east = (x+1,y)
 * 	southeast = (x+1,y-1)
 * 	south = (x,y-1)
 * 	southwest = (x-1,y-1)
 * 	west = (x-1,y)
 * 	northwest = (x-1,y+1)
 *
 * Since no assumptions are made about the grid in which a given
 * position exists, these directions may or may not indicate "valid"
 * positions for a given grid. Likewise, since no assumptions are
 * made about location of the origin within the grid in which a given
 * position exisits, some directions may be "reversed" from the
 * true orientation of a given grid.
 *
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2013-04-02
 *
 */

public class Position {
   
   private int x; 
   private int y;
   
   
   Position () {
      x = 0;
      y = 0;
   }
      
   Position (int x, int y) {
      this.x = x;
      this.y = y;
   }
      
   public int getx() {
      return x;
   }
   
   public int gety() {
      return y;
   }
   
   public void setx(int i) {
      x = i;
   }
   
   public void sety(int i) {
      y = i;
   }
   
   public Position north() {
      return new Position(x, y + 1);
   }
   	
   public Position northeast() {
      return new Position(x + 1, y + 1);
   }
   
   public Position east() {
      return new Position(x + 1, y);
   }
   
   public Position southeast() {
      return new Position(x + 1, y - 1);
   }
    
   public Position south() {
      return new Position(x, y - 1);
   }
   
   public Position southwest() {
      return new Position(x - 1, y - 1);
   }
   
   public Position west() {
      return new Position(x - 1, y);
   }
   
   public Position northwest() {
      return new Position(x - 1, y + 1);
   }
   
   public boolean equals (Object obj) {
      if (obj == this ) 
         return true;
      if (obj == null) 
         return false;
      if (obj.getClass() != this.getClass())
         return false;
   
      Position that = (Position) obj;
      return (this.x == that.x) && (this.y == that.y);
   }
   
   public String toString() {
      return "(" + x + "," + y + ")";
   }
   
}

