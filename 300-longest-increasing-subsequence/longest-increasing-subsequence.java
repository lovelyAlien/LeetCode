class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        
        for(int num : nums) {
            if(arr.isEmpty() || arr.get(arr.size()-1)<num) {
                arr.add(num);
            }
            else {
                int pos = binarySearch(arr, num);
                arr.set(pos, num);
            }
        }
        return arr.size();
    }

    public int binarySearch(List<Integer> arr, int target) {
        int left = 0; 
        int right = arr.size()-1;

        while(left<=right) {
            int mid = (left+ right)/2;
            if(arr.get(mid) == target) {
                return mid;
            }
            else if(arr.get(mid) <target) {
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return left;
    }
}