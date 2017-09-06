package T101_end;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class T207 {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) return true;
		int numEdges = prerequisites.length;
		Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
		int[] edgesTo = new int[numCourses];
		for (int i = 0; i < numEdges; i ++) {
			edgesTo[prerequisites[i][0]] ++;
			if (!edges.containsKey(prerequisites[i][1])) 
				edges.put(prerequisites[i][1], new ArrayList<Integer>());
			List<Integer> targets = edges.get(prerequisites[i][1]);
			targets.add(prerequisites[i][0]);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i ++) 
			if (edgesTo[i] == 0)
				queue.offer(i);
		int count = 0;
		while (!queue.isEmpty()) {
			int course = queue.remove();
			count ++;
			List<Integer> targets = edges.get(course);
			if (targets != null)
				for (Integer target: targets) {
					if (-- edgesTo[target] == 0)
						queue.add(target);
				}
		}
		if (count < numCourses) return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T207 t207 = new T207();
		int n = 2;
		int[][] matrix = {
//				{0, 1},
				{1, 0}
		};
		System.out.println(t207.canFinish(n, matrix));
	}

}
