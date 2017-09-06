package T535;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {

    private String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i ++) {
            int a = rand.nextInt(62);
            if (a < 10) sb.append(String.valueOf(a));
            else if (a < 36)
                sb.append((char)(65 + a - 10));
            else
                sb.append((char)(97 + a - 36));
        }
        return "http://" + sb.toString();
    }

    private Map<String, String> code2Url;
    private Map<String, String> url2Code;

    public Codec() {
        code2Url = new HashMap<>();
        url2Code = new HashMap<>();
    }

    public String encode(String longUrl) {
        String code = null;
        while (!url2Code.containsKey(longUrl)) {
            code = getRandomString(6);
            if (!code2Url.containsKey(code)) {
                code2Url.put(code, longUrl);
                url2Code.put(longUrl, code);
            }
        }
        return code;
    }

    public String decode(String shortUrl) {
        if (code2Url.containsKey(shortUrl))
            return code2Url.get(shortUrl);
        return null;

    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.decode(codec.encode("http://www.leetcode.com"));
    }
}
