class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];

        return Math.max(getMaxRob(nums,0, n-1), getMaxRob(nums,1,n));
    }


    public int getMaxRob(int[] nums, int start, int end) {
        int maxRob = 0;
        int preRob = 0;
        
        for(int i=start;i<end;i++) {
            int curVal = nums[i];
            int temp = Math.max(maxRob, curVal + preRob);
            preRob = maxRob; 
            maxRob = temp;
        }

        return maxRob;
    }
}