class Solution {
    public int missingInteger(int[] nums) {
     int sum=nums[0];
    // Sequential prefix sum
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Array ke elements ko HashSet me store karo
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Sum se start karke smallest missing integer dhoondo
        while (set.contains(sum)) {
            sum++;
        }

        return sum;   
    }
}