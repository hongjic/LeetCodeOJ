package T271;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Codec {

	public String encode(List<String> strs) {
		StringBuffer len = new StringBuffer();
		StringBuffer content = new StringBuffer();
		for (int i = 0; i < strs.size(); i ++) {
			len.append(strs.get(i).length()).append('|');
			content.append(strs.get(i));
		}
		return String.valueOf(strs.size()) + ":" + len.toString() + content.toString();
	}
	
	public List<String> decode(String s) {
		List<String> strs = new ArrayList<String>();
		int size = Integer.valueOf(s.substring(0, s.indexOf(':')));
		
		StringBuffer buffer = new StringBuffer(s);
		buffer.delete(0, s.indexOf(':') + 1);
		int[] len = new int[size];
		for (int i = 0; i < size; i ++) {
			int p = buffer.indexOf("|");
			len[i] = Integer.valueOf(buffer.substring(0, p));
			buffer.delete(0, p + 1);
		}
		for (int i = 0; i < size; i ++) {
			strs.add(buffer.substring(0, len[i]));
			buffer.delete(0, len[i]);
		}
		return strs;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Codec codec = new Codec();
		List<String> list = Arrays.asList("|:|a:bc|", ":d|ef|", "|a:d|f", "|b:c|:d|:|");
		List<String> result = codec.decode(codec.encode(list));
		for (int i = 0; i < result.size(); i ++)
			System.out.println(result.get(i));
	}

}
