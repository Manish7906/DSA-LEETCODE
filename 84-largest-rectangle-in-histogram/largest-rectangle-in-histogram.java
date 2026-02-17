class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] left = nextSmallerToLeft(heights, n);
        int[] right = nextSmallerToRight(heights, n);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private int[] nextSmallerToLeft(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        return left;
    }

    private int[] nextSmallerToRight(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] right = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        return right;
    }
}
