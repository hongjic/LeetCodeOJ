package T12_56;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T49 {
	
	
	public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {""};
		T49 t49 = new T49();
		List<List<String>> res = t49.groupAnagrams(str);
		for (int i=0; i<res.size(); i++) {
			for (int j=0; j<res.get(i).size(); j++)
				System.out.print(res.get(i).get(j)+", ");
			System.out.println();
		}
	}

}




//public class Solution {
//	   public List<List<String>> groupAnagrams(String[] strs) {
//	       List<List<String>>result= new ArrayList<>();
//	       Map<String,List<String>> map = new HashMap<String,List<String>>();
//
//	       for(String s:strs)
//	     {
//	           char[]c= s.toCharArray(); 
//	           Arrays.sort(c);                  
//
//	     //all Anagrams will be the same string if sorted  (tea,eat -->aet) , which serves as our key
//
//	         String keyStr= String.valueOf(c);
//	         if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
//	         map.get(keyStr).add(s);
//	      }
//
//	  //All the key value entries are stored in an entrySet which helps us return those values that have a key corresponding to it
//
//	     for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//
//	           List<String> values = entry.getValue();
//
//	           //since we want lexicographic order of the result, we sort the list
//	           Collections.sort(values);               
//
//	           result.add(values);
//	      }
//
//	     return result;   
//	  }
//	}