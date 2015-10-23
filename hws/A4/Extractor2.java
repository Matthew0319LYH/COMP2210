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
 * Extractor.java. Implements feature extraction for collinear points 
 * in 2D data.
 *
 * @author Dean Hendrix
 * @author Xing Wang
 * @version 2015-10-07
 *
 */

public class Extractor {

    private TreeSet<Point> pointSet = new TreeSet<>();

    public Extractor(String filename) throws FileNotFoundException, IOException {
		try {
	    	FileReader fr = new FileReader(filename);
	    	BufferedReader bf = new BufferedReader(fr);

	    	String lineRead = br.readLine();
	    	int N = Integer.parseInt(lineRead.trim());

	    	StringTokenizer st = new StringTokenizer(lineRead);
	    	int x, y;
	    	for (int i = 0; i < N; i++) {
				lineRead = br.readLine();
				st = new StringTokenizer(lineRead);
				x = Integer.parseInt(st.nextToken().trim());
				y = Integer.parseInt(st.nextToken().trim());
				pointSet.add(new Point(x, y));
	    	}
		}
		catch (Exception e) {}
    }
 
    public Extractor(Collection<Point> pcoll) {
    	for (Point p : pcoll) {
    		pointSet.add(p);
    	}
    }

    public SortedSet<Line> getLineBrute() {
    	SortedSet<Line> lineSet = new TreeSet<>();

    	for (Point p1 : pointSet) {
    		for (Point p2 : pointSet) {
    			for (Point p3 : pointSet) {
    				for (Point p4 : pointSet) {
    					Line l = new Line();
    					l.add(p1);
    					l.add(p2);
    					l.add(p3);
    					l.add(p4);
    					if (l.length() == 4) {
    						lineSet.add(l);
    					}
    				}
    			}
    		}
    	}
    	return lineSet;
    }

    public SortedSet<Line> getLineFast() {
    	int threshold = 4;
    	SortedSet<Line> lineSet = new TreeSet<>();

    	int N = 0;
    	Point[] pArray = Point[N];
    	for (Point p : pointSet) {
    		pArray[N++] = p;
    	}

    	for (Point p : pointSet) {
    		Arrays.sort(pArray, p.SLOPE_ORDER);


    		int j = 0;
    		Line l = new Line();
    		l.add(pArray[0]);
    		while((j <= pArray.length - threshold +1) && )
    	}
    }


}
