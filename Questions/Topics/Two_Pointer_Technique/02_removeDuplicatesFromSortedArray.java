https://leetcode.com/problems/remove-duplicates-from-sorted-array/?utm_source=instabyte.io&utm_medium=referral&utm_campaign=interview-master-100


#code 

  class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;

    }
}
