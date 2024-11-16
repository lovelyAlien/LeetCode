class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //난 됐다. 오늘의 집 개발자다. 그에 따른 행동을 하자. 

        // text.charAt(i)
        // 난 됐다. 오늘의 집 개발자다. 그에 따른 행동을 하자.

        // 최장 공통 부분 문자열을 찾아야 한다.
        // "abcde", "ace"

        // dp[i][j]: 1번째 부터 i번째 까지 문자열과 1번째 부터 j번째 까지 문자열 최장 공통 부분 문자열 길이

        int[][] dp= new int[text1.length()+1][text2.length()+1];

        for(int i =1;i<=text1.length();i++)
            for(int j =1;j<=text2.length();j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }

        return dp[text1.length()][text2.length()];

        
    }
}