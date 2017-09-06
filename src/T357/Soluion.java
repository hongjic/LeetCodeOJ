package T357;

public class Soluion {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int i = 2, count = 10, base = 9;
        while (i <= Math.min(10, n)) {
            base *= (11 - i);
            count += base;
            i ++;
        }
        return count;
    }
}
