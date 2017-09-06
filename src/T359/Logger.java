package T359;

import java.util.Map;
import java.util.HashMap;

public class Logger {

	private Map<String, Integer> logs;
	
	public Logger() {
		logs = new HashMap<String, Integer>();
	}
	
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (logs.containsKey(message) && logs.get(message) > timestamp - 10)
			return false;
		logs.put(message, timestamp);
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log = new Logger();
		System.out.println(log.shouldPrintMessage(1, "foo"));
		System.out.println(log.shouldPrintMessage(2, "bar"));
		System.out.println(log.shouldPrintMessage(3, "foo"));
		System.out.println(log.shouldPrintMessage(8, "bar"));
		System.out.println(log.shouldPrintMessage(10, "foo"));
		System.out.println(log.shouldPrintMessage(11, "foo"));
	}

}
