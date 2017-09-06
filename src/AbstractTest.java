import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public abstract class AbstractTest {

	public abstract void print();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractTest instance = new AbstractTest(){
			@Override
			public void print() {
				System.out.println("222");
			}
		};
		instance.print();
		String name = instance.getClass().getName();
		List<Integer> arr = Arrays.asList(1,2,3,4,5);
		Collections.sort(arr, (i1, i2) -> i1 - i2);
	}

}
