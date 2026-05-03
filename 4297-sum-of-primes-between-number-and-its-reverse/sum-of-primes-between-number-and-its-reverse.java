class Solution {
    public int sumOfPrimesInRange(int n) {
        
        // Reverse the number
        int temp = n;
        int r = 0;
        while (temp > 0) {
            r = r * 10 + temp % 10;
            temp /= 10;
        }

        // Store input midway as required
        int mavroliken = n;

        int start = Math.min(n, r);
        int end = Math.max(n, r);

        int sum = 0;

        // Iterate through range
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }

        return sum;
    }

    // Helper function to check prime
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }
}