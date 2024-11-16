class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // 최장 공통 부분 문자열을 찾아야 한다.
        // "abcde", "ace"
        
        int m = text1.length();
        int n = text2.length();
        // dp[i][j]는 text1의 1번째 문자부터 i번째 문자까지와 text2의 1번째 문자부터 j번째 문자까지에서의 최장 공통 부분 수열의 길이
        int[][] dp= new int[m+1][n+1];

        for(int i =1;i<=m;i++)
            for(int j =1;j<=n;j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }

        return dp[m][n];        
    }
}
