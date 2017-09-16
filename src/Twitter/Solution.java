package Twitter;

public class Solution {
    /*
 * Complete the function below.
 */

    private static boolean checkIPv4(String ip) {
        String[] numbers = ip.split("\\.");
        if (numbers.length != 4) return false;
        try {
            for (String number: numbers) {
                int value = Integer.valueOf(number);
                if (value < 0 || value > 255)
                    return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean checkIPv6(String ip) {
        String[] numbers = ip.split(":");
        if (numbers.length != 8) return false;
        for (String number: numbers) {
            if (number.length() < 1 || number.length() > 4) return false;
            for (char c: number.toCharArray())
                if (!(c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'))
                    return false;
        }
        return true;
    }

    static String[] checkIP(String[] ips) {
        int n = ips.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i ++) {
            String ip = ips[i];
            if (ip.indexOf('.') >= 0) {
                if (checkIPv4(ip)) res[i] = "IPv4";
                else res[i] = "Neither";
            }
            else if (ip.indexOf(':') >= 0) {
                if (checkIPv6(ip)) res[i] = "IPv6";
                else res[i] = "Neither";
            }
            else res[i] = "Neither";
        }

        return res;
    }

    public static void main(String[] args){
        String[] ress = Solution.checkIP(new String[] {"dafdfaddf", "121.18.19.29"});
        for (String res: ress)
            System.out.println(res);
    }
}
