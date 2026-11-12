class Solution {
    public long maximizeSum(int[] nums, int k) {

        long sum = 0;
        int n = nums.length;

        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {

            int num = nums[i];
            sum += num;

            char[] digits = String.valueOf(num).toCharArray();

            Arrays.sort(digits);

            StringBuilder sb = new StringBuilder();

            for (int j = digits.length - 1; j >= 0; j--) {
                sb.append(digits[j]);
            }

            int maxNum = Integer.parseInt(sb.toString());

            gain[i] = maxNum - num;
        }

        Arrays.sort(gain);

        for (int i = n - 1; i >= 0 && k > 0; i--) {
            sum += gain[i];
            k--;
        }

        return sum;
    }
}
