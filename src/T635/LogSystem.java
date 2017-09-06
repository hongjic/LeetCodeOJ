package T635;

import java.util.*;

/*
The principal is similar to a Trie tree. O(1) for put() and O(k) for retrieve().
`k` is the number of unique timestamps in the query result.
While nodes in a Trie are identical, in this problem, we have different classes such as:
Year, Month, Hour, etc and behave differently.
Customize classes of each layer in the timestamp and use inheritance to reduce verbosity.
 */
public class LogSystem {

    private static int parseLog(String part, String timestamp) {
        if (part == "Year")
            return Integer.valueOf(timestamp.substring(0, 4)) - 2000;
        if (part == "Month")
            return Integer.valueOf(timestamp.substring(5, 7)) - 1;
        if (part == "Day")
            return Integer.valueOf(timestamp.substring(8, 10)) - 1;
        if (part == "Hour")
            return Integer.valueOf(timestamp.substring(11, 13));
        if (part == "Minute")
            return Integer.valueOf(timestamp.substring(14, 16));
        return Integer.valueOf(timestamp.substring(17, 19));
    }

    private static abstract class TimeNode {
        protected int value;
        protected String type, childType;

        protected abstract TimeNode[] getSubNodes();

        protected abstract TimeNode newSubNode(int index);

        public void addLog(int id, String timestamp) {
            int index = parseLog(childType, timestamp);
            TimeNode[] nodes = getSubNodes();
            if (nodes[index] == null) nodes[index] = newSubNode(index);
            nodes[index].addLog(id, timestamp);
        }

        public Set<Integer> retrieveAll() {
            Set<Integer> res = new HashSet<>();
            for (TimeNode node: getSubNodes())
                if (node != null)
                    res.addAll(node.retrieveAll());
            return res;
        }

        public Set<Integer> retrieve(String start, boolean startChecked, String end, boolean endChecked, String granularity) {
            int startIndex = parseLog(type, start);
            int endIndex = parseLog(type, end);

            if ((!startChecked && value < startIndex) || (!endChecked && value > endIndex))
                return new HashSet<>();
            if (!startChecked && value > startIndex) startChecked = true;
            if (!endChecked && value < endIndex) endChecked = true;
            if (startChecked && endChecked || granularity.equals(type)) return retrieveAll();
            Set<Integer> res = new HashSet<>();
            for (TimeNode node: getSubNodes())
                if (node != null)
                    res.addAll(node.retrieve(start, startChecked, end, endChecked, granularity));
            TreeMap<Integer, Integer> map = new TreeMap<>();
            return res;
        }
    }

    private static class Year extends TimeNode {
        private final Month[] months = new Month[12];

        public Year(int v) {
            type = "Year"; childType = "Month";
            value = v;
        }

        @Override
        protected TimeNode[] getSubNodes() { return months; }

        @Override
        protected TimeNode newSubNode(int index) { return new Month(index); }
    }

    private static class Month extends TimeNode {
        private final Day[] days = new Day[31];

        public Month(int v) {
            type = "Month"; childType = "Day";
            value = v;
        }

        @Override
        protected TimeNode[] getSubNodes() { return days; }

        @Override
        protected TimeNode newSubNode(int index) { return new Day(index); }
    }

    private static class Day extends TimeNode {
        private final Hour[] hours = new Hour[24];

        public Day(int v) {
            type = "Day"; childType = "Hour";
            value = v;
        }

        @Override
        protected TimeNode[] getSubNodes() { return hours; }

        @Override
        protected TimeNode newSubNode(int index) { return new Hour(index); }
    }

    private static class Hour extends TimeNode {
        private final Minute[] minutes = new Minute[60];

        public Hour(int v) {
            type = "Hour"; childType = "Minute";
            value = v;
        }

        @Override
        protected TimeNode[] getSubNodes() { return minutes; }

        @Override
        protected TimeNode newSubNode(int index) { return new Minute(index); }
    }

    private final static class Minute extends TimeNode {
        private final Second[] seconds = new Second[60];

        public Minute(int v) {
            type = "Minute"; childType = "Second";
            value = v;
        }

        @Override
        protected TimeNode[] getSubNodes() { return seconds; }

        @Override
        protected TimeNode newSubNode(int index) { return new Second(index); }
    }

    private static class Second extends TimeNode {
        private final Set<Integer> idSet = new HashSet<>();

        public Second(int v) {
            type = "Second";
            value = v;
        }

        @Override
        protected TimeNode newSubNode(int index) { return null; }

        @Override
        protected TimeNode[] getSubNodes() { return null; }

        @Override
        public void addLog(int id, String timestamp) { idSet.add(id); }

        @Override
        public Set<Integer> retrieveAll() { return idSet; }
    }

    private Year[] years;

    public LogSystem() {
        years = new Year[18];
    }

    public void put(int id, String timestamp) {
        int year = parseLog("Year", timestamp);
        if (years[year] == null) years[year] = new Year(year);
        years[year].addLog(id, timestamp);
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> res = new ArrayList<>();
        for (Year year: years)
            if (year != null)
                res.addAll(year.retrieve(start, false, end, false, granularity));
        return res;
    }

    public static void main(String[] args) {
        LogSystem logSys = new LogSystem();
        logSys.put(1, "2017:01:01:23:59:59");
        logSys.put(2, "2017:01:02:23:59:59");
        List<Integer> res = logSys.retrieve("2017:01:01:23:59:58","2017:01:02:23:59:58","Second");
        for (int i: res)
            System.out.print(i + ", ");
        System.out.println();
        res = logSys.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");
        for (int i: res)
            System.out.print(i + ", ");
        System.out.println();
    }
}
