import java.math.BigInteger;
import java.util.ArrayList;

class Solution {
    public String nearestPalindromic(String n) {
        BigInteger num = new BigInteger(n);

        if (num.compareTo(BigInteger.TEN) <= 0) {
            return num.subtract(BigInteger.ONE).toString();
        }

        int length = n.length();
        ArrayList<BigInteger> palindromes = new ArrayList<>();

        palindromes.add(BigInteger.TEN.pow(length).add(BigInteger.ONE)); 
        palindromes.add(BigInteger.TEN.pow(length - 1).subtract(BigInteger.ONE)); 

        int mid = (length + 1) / 2;
        BigInteger prefix = new BigInteger(n.substring(0, mid));
        BigInteger[] prefixArr = {prefix, prefix.add(BigInteger.ONE), prefix.subtract(BigInteger.ONE)};

        for (BigInteger pref : prefixArr) {
            String firstHalf = pref.toString();
            String reverse = new StringBuilder(firstHalf.substring(0, length % 2 == 0 ? firstHalf.length() : firstHalf.length() - 1)).reverse().toString();
            palindromes.add(new BigInteger(firstHalf + reverse));
        }

        BigInteger result = null;
        BigInteger difference = null;

        for (BigInteger palindrome : palindromes) {
            if (!palindrome.equals(num)) {
                BigInteger diff = num.subtract(palindrome).abs();
                if (difference == null || diff.compareTo(difference) < 0 || (diff.compareTo(difference) == 0 && palindrome.compareTo(result) < 0)) {
                    difference = diff;
                    result = palindrome;
                }
            }
        }

        return result.toString();
    }
}
