package T149;

import java.text.DecimalFormat;

public class Line {
	
	Double k;
	Double b;
	Integer x;
	
	static DecimalFormat df = new DecimalFormat("#.#####");
	
	public Line() {}
	
	public Line(Point p1, Point p2) {
		if (p1.x == p2.x) {
			x = p1.x; 
		}
		else {
			k = (double)(p1.y - p2.y) / (p1.x - p2.x);
			b = p1.y - k * p1.x;
			k = Double.parseDouble(df.format(k));
			b = Double.parseDouble(df.format(b));
		}
	}
	
	@Override
	public boolean equals(Object o) {
		Line other = (Line)o;
		if (!(x != null && other.x != null && x.equals(other.x) || x == null && other.x == null)) 
			return false;
		if (!((k != null && other.k != null && b != null && other.b != null && k.equals(other.k) && b.equals(other.b)) || 
				(k == null && other.k == null && b == null && other.b == null)))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		int h = 0;
		h = h * 31 + (k == null ? 0 : Double.hashCode(k));
		h = h * 31 + (b == null ? 0 : Double.hashCode(b));
		h = h * 31 + (x == null ? 0 : Integer.hashCode(x));
		return h; 
	}
}