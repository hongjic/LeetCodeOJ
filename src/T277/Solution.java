package T277;

class Relation {
	boolean knows(int a, int b){
		return false;
	}
}

public class Solution extends Relation{
	public int findCelebrity(int n) {
		int celebrity = 0;
		for (int i = 1; i < n; i ++)
			if (knows(celebrity, i))
				celebrity = i;
		for (int i = 0; i < n; i ++)
			if (celebrity != i && (!knows(i,celebrity) || knows(celebrity, i)))
				return -1;
		return celebrity;
	}
}
