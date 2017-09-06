package T149;

public class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
	
	@Override
	public boolean equals(Object o) {
		Point other = (Point)o;
		if (x == other.x && y == other.y)
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return x * 31 + y;
	}
}
