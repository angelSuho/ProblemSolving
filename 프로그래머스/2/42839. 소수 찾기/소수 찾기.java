import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> primeNumbers = new HashSet<>();
        permutation("", numbers, primeNumbers);
        return primeNumbers.size();
    }

    private void permutation(String prefix, String str, Set<Integer> primeNumbers) {
        int n = str.length();
        if (!prefix.equals("")) {
            int num = Integer.parseInt(prefix);
            if (isPrime(num)) {
                primeNumbers.add(num);
            }
        }
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), primeNumbers);
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}