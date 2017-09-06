package T635;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
A more intuitive and concise implementation using BST inside TreeMap.
O(logn) for put(), O(k) for retrieve.
`k` is the number of records to retrieve. `n` is the total number of records.
 */
public class LogSystem2 {

    private static final String min = "2000:01:01:00:00:00";
    private static final String max = "2017:12:31:23:59:59";

    private static int getIndex(String granularity) {
        if (granularity.equals("Year")) return 4;
        if (granularity.equals("Month")) return 7;
        if (granularity.equals("Day")) return 10;
        if (granularity.equals("Hour")) return 13;
        if (granularity.equals("Minute")) return 16;
        return 19;
    }

    private TreeMap<String, LinkedList<Integer>> logs;

    public LogSystem2() {
        logs = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        if (!logs.containsKey(timestamp))
            logs.put(timestamp, new LinkedList<>());
        logs.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String s, String e, String granularity) {
        int index = getIndex(granularity);
        String start = s.substring(0, index) + min.substring(index);
        String end = e.substring(0, index) + max.substring(index);
        Map<String, LinkedList<Integer>> subMap = logs.subMap(start, true, end, true);

        LinkedList<Integer> res = new LinkedList<>();
        for (LinkedList<Integer> value: subMap.values())
            res.addAll(value);
        return res;
    }

    public static void main(String[] args) {
        LogSystem2 logSys2 = new LogSystem2();

        logSys2.put(1, "2017:01:01:23:59:59");
        logSys2.put(2, "2017:01:01:22:59:59");
        logSys2.put(3, "2016:01:01:00:00:00");
        logSys2.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
        logSys2.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");
    }
}
