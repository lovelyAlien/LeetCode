class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // wordDict를 Set으로 만들어서 탐색 시간을 줄임
        int n = s.length();
        // dp[i]: 처음부터 i까지 분할 가능한지(wordDict에 존재하는지)
        boolean[] dp = new boolean[n];

        for(int i=0;i<n;i++) {
            String sub = s.substring(0,i+1);
            if(wordSet.contains(sub)) {
                dp[i]=true;
            }
        }

        for(int i=0;i<n;i++) {
            if(dp[i]) {
                for(int j=i+1;j<n;j++) {
                    String sub = s.substring(i+1,j+1);
                    if(wordSet.contains(sub)) {
                        dp[j]=true;
                    }
                }
            }
        }

        return dp[n-1];
    }
}