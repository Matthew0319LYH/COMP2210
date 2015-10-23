import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  Dean Hendrix	(dh@auburn.edu)
 * @author	Xing Wang		(xzw0005@auburn.edu)
 * @version 2015-09-23
 *
 */
public class Extractor {
	// TODO
	private TreeSet<Point> pointSet = new TreeSet<>(); 
	// END TODO
  
	/** resolution settings for stdlib drawing. */
	private static int HI_RES = 32768;
	private static int LO_RES = 32;
     
	/**
	 * Builds an extractor based on the points in the
	 * file named by filename. 
	 */
	public Extractor(String filename) throws IOException {
		
		// TODO
		//BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			FileReader fr = new FileReader(filename); 
			BufferedReader br = new BufferedReader(fr);
         

			String firstLine = br.readLine();
			int N = Integer.parseInt(firstLine.trim());
	   
			StringTokenizer tokenizer = new StringTokenizer(firstLine);
			String xyLine;
			int x, y;
			for (int i = 0; i < N; i++) {
				xyLine = br.readLine();
				tokenizer = new StringTokenizer(xyLine);
				x = Integer.parseInt(tokenizer.nextToken().trim());
				y = Integer.parseInt(tokenizer.nextToken().trim());
				pointSet.add(new Point(x, y));
			}
			fr.close();         
		}
		catch (Exception e) {}
	   //END TODO
	}
  
   /**
    * Builds an extractor based on the points in the
    * Collection named by pcoll. 
    */
	public Extractor(Collection<Point> pcoll) {
		// TODO
		for (Point p : pcoll) {
			pointSet.add(p);
		}
		// END TODO
	}
  
   /**
    * Returns a sorted set of all line segments of exactly four
    * collinear points. Uses a brute-force combinatorial
    * strategy. Returns an empty set if there are no qualifying
    * line segments.
    */
	public SortedSet<Line> getLinesBrute() {
		//return null;
		// TODO
		SortedSet<Line> lineSet = new TreeSet<>();
		//int N = pointSet.size();
		for (Point p1 : pointSet) { 	//for (int i = 0; i < N - 3; i++) {
			for (Point p2 : pointSet) { 	//for (int j = i + 1; j < N - 2; j++) {
				for (Point p3 : pointSet) {	//for (int k = j + 1; k < N - 1; k++) {
					for (Point p4 : pointSet) { 	//for (int l = k + 1; l < N; l++) {
						Line line = new Line();
						line.add(p1);
						line.add(p2);
						line.add(p3);
						line.add(p4);		
						if (line.length() == 4) { lineSet.add(line); }
					}
				}
			}
		}
		return lineSet;
	  // END TODO
	}
  
   /**
    * Returns a sorted set of all line segments of at least four
    * collinear points. The line segments are maximal; that is,
    * no sub-segments are identified separately. A sort-and-scan
    * strategy is used. Returns an empty set if there are no qualifying
    * line segments.
    */
	public SortedSet<Line> getLinesFast() {
		// TODO
		int threshold = 4;
		SortedSet<Line> lineSet = new TreeSet<Line>();
		Point[] pointArray = new Point[pointSet.size()];
		//double[] slopeArray = new double[pointSet.size()];

		int N = 0;
		for (Point p : pointSet) {
			pointArray[N++] = p;
		}
		//Point[] pointArray = Arrays.CopyOf(pointSet.asList()); // Clever idea by a classmate


		/*for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) { 
				slopeArray[j] = pointArray[i].slopeTo(pointArray[j]);
			}
			Arrays.sort(slopeArray);
			int j = 1;
			while (j <= N - threshold + 1) {
				Line line = new Line();
				line.add(pointArray[0]);
				int k = j + 1;
				while (k < N && (slopeArray[k] == slopeArray[j])) {
					line.add(pointArray[k]);
					k++;
				}
				if (line.length() >= threshold) {
					lineSet.add(line);
				}
				j = k;
			}
		}*/

		for (Point p : pointSet) {
			Arrays.sort(pointArray, p.SLOPE_ORDER);
			//for (int i = 1; i <= N - threshold + 1;) { 
			int i = 1;
			while (i <= N - threshold + 1) {
				Line line = new Line();
				line.add(pointArray[0]);
				while(i < N && line.add(pointArray[i])){ 
					i++;
				}
				if (line.length() >= threshold) {
					lineSet.add(line);
				}
			}
		}

		return lineSet;
		// END TODO
   }
  
	// Draw all points to a graphics window. 
	public void drawPoints() {
	// optional
	// TODO
	/*for (Point p : pointSet) {
		p.draw();
	}*/
	// END TODO
	}
  
	// Draw all identified lines, if any, to a graphics window. 
	public void drawLines() {
	// optional
	/*SortedSet<Line> lineSet = getLinesFast();
	for (Line l : lineSet) {
		l.first().drawTo(l.last());
	}*/
	}
      
}
