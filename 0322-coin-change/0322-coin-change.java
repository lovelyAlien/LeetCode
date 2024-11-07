class Solution {
    public int coinChange(int[] coins, int amount) {
        // DP 배열 생성 및 초기화
        // amount + 1로 초기화하는 이유: 어떤 경우에도 amount보다 많은 동전이 필요하지 않음
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0; 

        for(int curAmount=1;curAmount<=amount;curAmount++) {
            for(int coin : coins) {
                if(curAmount>=coin) {
                    dp[curAmount] = Math.min(dp[curAmount], 1 + dp[curAmount-coin]);
                }
            }
        }

        // 불가능한 경우 -1 반환, 가능한 경우 최소 동전 개수 반환
        return dp[amount] > amount ? -1 : dp[amount];
    }
}