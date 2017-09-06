package T12_56;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class T30 {

	private static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
        if(words == null || words.length == 0 || s.length() == 0) return res;
        int wordLen = words[0].length();
        int numWord = words.length;
        int windowLen = wordLen * numWord;
        int sLen = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        for(int i = 0; i < wordLen; i++) {  // Run wordLen scans
            HashMap<String, Integer> curMap = new HashMap<>();
            for(int j = i, count = 0, start = i; j + wordLen <= sLen; j += wordLen) {  // Move window in step of wordLen
                // count: number of exceeded occurences in current window
                // start: start index of current window of size windowLen
                if(start + windowLen > sLen) break;
                String word = s.substring(j, j + wordLen);
                if(!map.containsKey(word)) {
                    curMap.clear();
                    count = 0;
                    start = j + wordLen;
                }
                else {
                    if(j == start + windowLen) { // Remove previous word of current window
                        String preWord = s.substring(start, start + wordLen);
                        start += wordLen;
                        int val = curMap.get(preWord);
                        if(val == 1) curMap.remove(preWord);
                        else curMap.put(preWord, val - 1);
                        if(val - 1 >= map.get(preWord)) count--;  // Reduce count of exceeded word
                    }
                    // Add new word
                    curMap.put(word, curMap.getOrDefault(word, 0) + 1);
                    if(curMap.get(word) > map.get(word)) count++;  // More than expected, increase count
                    // Check if current window valid
                    if(count == 0 && start + windowLen == j + wordLen) {
                        res.add(start);
                    }
                }
            }
        }
        return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list = {"foo", "bar", "man"};
		System.out.println(findSubstring("barfoothemanfoobarman", list));
	}

}



//public class Solution {
//    public List<Integer> findSubstring(String s, String[] words) {
//    List<Integer> res = new ArrayList<Integer>();
//    int sLen          = s.length();
//    int wNum          = words.length;
//    if (sLen == 0 || wNum == 0 || words[0].length() == 0) {
//        return res;
//    }
//
//    int wLen = words[0].length();
//    Map<String, Integer> map = new HashMap<String, Integer>();
//    int[] counts = new int[wNum];
//
//    //Mapping words to integer IDs and count the occurrences of each unique word int the given word array
//    for (int i = 0; i < wNum; i ++) {
//        Integer id = map.get(words[i]);
//        if (id == null) {
//            id = map.size();
//            map.put(words[i], id);
//        }
//        counts[id] ++;
//    }
//
//    int mNum = sLen - wLen + 1;
//    List<List<Integer>> matchLists = new ArrayList<List<Integer>>();
//    for (int i = 0; i < wLen; i ++) {
//        matchLists.add(new ArrayList<Integer>());
//    }
//
//    //scan the s string and convert the string into wLen different ID lists
//    for (int i = 0; i < mNum; i ++) {
//        matchLists.get(i%wLen).add(map.get(s.substring(i, i + wLen)));
//    }
//
//    //scan each ID list with a wNum-long window and see whether a window has all the words in given words array
//    for (int offset = 0; offset < wLen; offset ++) {
//        List<Integer> list = matchLists.get(offset);
//        int[] cMap = new int[wNum];
//        int pos = -1;
//        for (int begin = 0, end = wNum - 1; end < list.size(); begin ++, end ++) {
//
//            //expire the invalid IDs
//            if (pos < begin) {
//                pos = begin;
//            }
//
//            while (pos <= end) {
//                Integer id = list.get(pos);
//
//                // it means a unknown word found or a word having too many occurrences in the window
//                if (id == null || cMap[id] == counts[id]) {
//                    break;
//                }
//                cMap[id] ++;
//                pos ++;
//            }
//
//            // means the window have all the words
//            if (pos == end + 1) {
//                res.add(offset + begin * wLen);
//            }
//
//            //remove the count of the word at the old position
//            Integer oldId = list.get(begin);
//            if (oldId != null) {
//                cMap[oldId] --;
//            }
//        }
//    }
//
//    return res;
//}
//}