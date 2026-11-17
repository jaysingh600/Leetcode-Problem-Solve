class Solution {
    int[] dp;
    int n;
    public int maxJumps(int[] arr, int d) {
      n = arr.length;
        dp = new int[n];

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(arr, d, i));
        }

        return ans;
    }

    private int dfs(int[] arr, int d, int i) {

        if (dp[i] != 0) {
            return dp[i];
        }

        int max = 1;

        // Move Right
        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {

            // Cannot jump over greater/equal element
            if (arr[j] >= arr[i]) {
                break;
            }

            max = Math.max(max, 1 + dfs(arr, d, j));
        }

        // Move Left
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {

            // Cannot jump over greater/equal element
            if (arr[j] >= arr[i]) {
                break;
            }

            max = Math.max(max, 1 + dfs(arr, d, j));
        }

        dp[i] = max;
        return max;   
    }
}