package T149;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Solution {
	
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) 
			return 0;
		Map<Line, Set<Integer>> lineMap = new HashMap<Line, Set<Integer>>();
		Map<Point, Integer> pointMap = new HashMap<Point, Integer>();
	
		for (int i = 0; i < points.length; i ++) {
			pointMap.put(points[i], pointMap.getOrDefault(points[i], 0) + 1);
			for (int j = 0; j < i; j ++)
				if (points[i].x != points[j].x || points[i].y != points[j].y) {
					Line line = new Line(points[i], points[j]);
					if (!lineMap.containsKey(line))
						lineMap.put(line, new HashSet<Integer>());
					Set<Integer> set = lineMap.get(line);
					set.add(i);
					set.add(j);
				}
		}
		int max = 0;
		for (Line line: lineMap.keySet()) 
			max = Math.max(max, lineMap.get(line).size());
		for (Point point: pointMap.keySet())
			max = Math.max(max, pointMap.get(point));
		return max;
	}
	
	public static void main(String[] args) {
		Point[] points = new Point[]{new Point(560,248), new Point(-3,-52), new Point(560,248)};
		System.out.println(new Solution().maxPoints(points));
	}
	
}
