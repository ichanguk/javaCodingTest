import java.util.*;

class Solution {
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.pow(n, 0.5); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private void getPrimes(int acc, int[] nums, boolean[] isUsed, Set<Integer> primes) {
        if (isPrime(acc)) {
            primes.add(acc);
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            int nextAcc = acc * 10 + nums[i];
            
            isUsed[i] = true;
            getPrimes(nextAcc, nums, isUsed, primes);
            isUsed[i] = false;
        }
    }
    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        int[] nums = numbers.chars().map(c -> c - '0').toArray();
        getPrimes(0, nums, new boolean[nums.length], primes);
        return primes.size();
    }
}