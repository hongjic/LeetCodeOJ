package T57_100;

import java.util.ArrayList;
import java.util.List;

public class T68 {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<String>();
		List<String> tem = new ArrayList<String>();
		int len = words.length;
		int i = 0, sum = 0;
		while (i < len ) {
			if (sum == 0) {
				sum = words[i].length();
				tem.add(words[i]);
			}
			else if (sum + words[i].length() + 1 <= maxWidth) {
				sum += words[i].length() + 1;
				tem.add(words[i]);
			}
			else { // over flow
				int less = maxWidth - sum;
				int average = 0, addfront = 0;
				if (tem.size() > 1) {
					average = less / (tem.size() - 1);
					addfront = less - average * (tem.size() - 1);
				}
				else {
					average = -1;
					addfront = less;
				}
				StringBuffer line = new StringBuffer();
				line.append(tem.get(0));
				StringBuffer space = new StringBuffer();
				for (int j = 0; j < average + 1; ++ j)
					space.append(' ');
				for (int j = 1; j < tem.size(); ++ j) {
					if (j <= addfront)
						line.append(' ');
					line.append(space).append(tem.get(j));
				}
				while (line.length() < maxWidth) 
					line.append(' ');
				res.add(line.toString());
				tem.clear();
				tem.add(words[i]);
				sum = words[i].length();
			}
			++ i;
		}
		StringBuffer lastline = new StringBuffer();
		lastline.append(tem.get(0));
		for (int j = 1; j < tem.size(); ++ j)
			lastline.append(' ').append(tem.get(j));
		while (lastline.length() < maxWidth) 
			lastline.append(' ');
		res.add(lastline.toString());
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T68 t68 = new T68();
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		List<String> res = t68.fullJustify(words, 16);
		for (int i = 0; i < res.size(); ++ i)
			System.out.println(res.get(i));
		
	}

}
