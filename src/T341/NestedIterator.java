package T341;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* 
 *  queue of list-> at the top is the current one
 * from the first --> end
 * 1 if nested --> go in --> 1
 * 2 if not nested --> go next -->3
 * 3 if no next --> [queue of list].pop, [queue of index].pop --> go next --> 1
 * 4 if next --> 1
 */ 

public class NestedIterator implements Iterator<Integer>{
	
	public static interface NestedInteger {
		
		public boolean isInteger();
		public Integer getInteger();
		public List<NestedInteger> getList();
		
	}
	
	private Stack<Integer> indexStack;
	private Stack<List<NestedInteger>> listStack;
	
	public NestedIterator(List<NestedInteger> nestedList) {
		indexStack = new Stack<Integer>();
		listStack = new Stack<List<NestedInteger>>();
		if (nestedList != null && nestedList.size() > 0) { 
			indexStack.push(0);
			listStack.push(nestedList);
			find();
		}
	}
	
	@Override
	public Integer next() {
		if (!hasNext()) return null;
		Integer current = listStack.peek().get(indexStack.peek()).getInteger();
		indexStack.set(indexStack.size() - 1, indexStack.peek() + 1);
		find();
		return current;
	}
	
	private void find() {
		while (!indexStack.isEmpty() && 
				(indexStack.peek() >= listStack.peek().size() || !listStack.peek().get(indexStack.peek()).isInteger())) {
			if (indexStack.peek() >= listStack.peek().size()) {
				indexStack.pop();
				listStack.pop();
				if (!indexStack.isEmpty()) 
					indexStack.set(indexStack.size() - 1, indexStack.peek() + 1);
				continue;
			}
			// current is a list
			listStack.push(listStack.peek().get(indexStack.peek()).getList());
			indexStack.push(0);
		}
	}
	
	@Override
	public boolean hasNext() {
		return !indexStack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
