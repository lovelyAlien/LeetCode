import java.util.*;
class Solution {
    public boolean canCross(int[] stones) {
        // 예외 케이스: 첫 번째 점프는 반드시 1단위여야 함
        if (stones[1] != 1) {
            return false;
        }
        
        int n = stones.length;
        
        // 빠른 조회를 위해 HashMap에 돌 위치 저장
        Map<Integer, Integer> stonePositions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            stonePositions.put(stones[i], i);
        }
        
        // dp[i][j]는 j 길이의 점프로 i번째 돌에 도달할 수 있는지 여부를 나타냄
        // 점프 길이는 최대 n일 수 있으므로, n 크기의 배열 사용
        boolean[][] dp = new boolean[n][n];
        
        // 기본 케이스: 첫 번째 돌에는 0 길이의 점프로 도달 가능
        dp[0][0] = true;
        
        // 모든 돌에 대해 반복
        for (int i = 0; i < n; i++) {
            for (int prevJump = 0; prevJump < n; prevJump++) {
                // 현재 돌에 prevJump 길이로 도달할 수 있다면
                if (dp[i][prevJump]) {
                    // 가능한 모든 다음 점프 시도: k-1, k, k+1
                    for (int nextJump = Math.max(1, prevJump - 1); nextJump <= prevJump + 1; nextJump++) {
                        int nextPosition = stones[i] + nextJump;
                        
                        // 다음 위치에 돌이 있는지 확인
                        if (stonePositions.containsKey(nextPosition)) {
                            int nextStoneIndex = stonePositions.get(nextPosition);
                            dp[nextStoneIndex][nextJump] = true;
                        }
                    }
                }
            }
        }
        
        // 어떤 점프 길이로든 마지막 돌에 도달할 수 있는지 확인
        for (int jump = 0; jump < n; jump++) {
            if (dp[n - 1][jump]) {
                return true;
            }
        }
        
        return false;
    }
}