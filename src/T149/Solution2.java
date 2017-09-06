package T149;

import java.util.Map;
import java.util.HashMap;

/*
 * A much better implementation
 * For the 0.0 trick, check "http://stackoverflow.com/questions/6724031/how-can-a-primitive-float-value-be-0-0-what-does-that-mean"
 */
public class Solution2 {

	public int maxPoints(Point[] points) {
		int max = 0;
		Map<Double, Integer> slopes = new HashMap<Double, Integer>();
		for (int i = 0; i < points.length; i ++) {
			int same = 1;
			slopes.clear();
			for (int j = i + 1; j < points.length; j ++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y)
					same ++;
				else if (points[i].x == points[j].x)
					slopes.put(Double.MAX_VALUE, slopes.getOrDefault(Double.MAX_VALUE, 0) + 1);
				else {
					double k = (double)(points[i].y - points[j].y) / (points[i].x - points[j].x) + 0.0;
					// 0.0 and -0.0 are not equal. you can get around the problem by adding 0.0
					slopes.put(k, slopes.getOrDefault(k, 0) + 1);
				}
			}
			int maxLocal = 0;
			for (double slope: slopes.keySet())
				maxLocal = Math.max(maxLocal, slopes.get(slope));
			maxLocal += same;
			max = Math.max(max, maxLocal);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = new Point[]{new Point(2,3), new Point(3,3), new Point(-5,3)};
		System.out.println(new Solution2().maxPoints(points));
	}

}
